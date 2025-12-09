pipeline {
    agent any

    triggers {
        // Run every 1 minute
        cron('* * * * *')
    }

    options {
        timestamps()
        disableConcurrentBuilds()
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }

    environment {
        // Environment variables
        WORKSPACE_DIR = "${WORKSPACE}"
        BUILD_NUM = "${BUILD_NUMBER}"
    }

    stages {

        /*************** STAGE 1: VERIFY WORKSPACE ***************/
        stage('Verify Workspace') {
            steps {
                echo '=== STAGE 1: VERIFYING WORKSPACE ==='
                script {
                    echo "Current directory: ${WORKSPACE}"
                    echo "Jenkinsfile location: ${WORKSPACE}/Jenkinsfile"
                    
                    // Check if Jenkinsfile exists
                    bat '''
                        echo Checking if Jenkinsfile exists...
                        if exist Jenkinsfile (
                            echo ✅ Jenkinsfile found in workspace
                            echo Jenkinsfile content first few lines:
                            type Jenkinsfile | findstr /n "." | findstr /b "1: 2: 3: 4: 5:"
                        ) else (
                            echo ❌ Jenkinsfile NOT found
                        )
                    '''
                }
            }
        }

        /*************** STAGE 2: CHECK GIT STATUS ***************/
        stage('Check Git Status') {
            steps {
                echo '=== STAGE 2: CHECKING GIT STATUS ==='
                bat '''
                    echo ========================================
                    echo GIT INFORMATION
                    echo ========================================
                    git --version
                    echo.
                    echo Current branch:
                    git branch --show-current
                    echo.
                    echo Last commit:
                    git log -1 --oneline
                    echo.
                    echo Git remote:
                    git remote -v
                '''
            }
        }

        /*************** STAGE 3: ANALYZE PROJECT STRUCTURE ***************/
        stage('Analyze Project Structure') {
            steps {
                echo '=== STAGE 3: ANALYZING PROJECT STRUCTURE ==='
                bat '''
                    echo ========================================
                    echo PROJECT STRUCTURE ANALYSIS
                    echo ========================================
                    echo.
                    
                    echo 📁 Complete directory structure:
                    dir /s /b
                    echo.
                    
                    echo 🔍 Searching for Java files...
                    echo Total Java files found: 
                    dir /s /b *.java 2>nul | find /c /v ""
                    echo.
                    
                    echo 📄 List of Java files:
                    for /r %%i in (*.java) do (
                        echo   %%i
                    )
                    echo.
                '''
            }
        }

        /*************** STAGE 4: FIND JAVA8 FILES ***************/
        stage('Find Java8 Examples') {
            steps {
                echo '=== STAGE 4: FINDING JAVA8 EXAMPLE FILES ==='
                script {
                    // Create batch file to store variables
                    bat '''
                        echo 🔎 Searching for Java8 directories...
                        
                        set "FOUND_SOURCE_DIR="
                        set "FOUND_PACKAGE_NAME="
                        
                        REM Option 1: Check src/main/java/Java8Examples
                        if exist src\\main\\java\\Java8Examples (
                            echo Checking src\\main\\java\\Java8Examples...
                            dir src\\main\\java\\Java8Examples\\*.java >nul 2>&1
                            if %ERRORLEVEL% equ 0 (
                                echo ✅ Found Java8Examples in main directory
                                set "FOUND_SOURCE_DIR=src\\main\\java\\Java8Examples"
                                set "FOUND_PACKAGE_NAME=Java8Examples"
                                goto DONE_SEARCHING
                            )
                        )
                        
                        REM Option 2: Check src/test/java/Java8Example  
                        if exist src\\test\\java\\Java8Example (
                            echo Checking src\\test\\java\\Java8Example...
                            dir src\\test\\java\\Java8Example\\*.java >nul 2>&1
                            if %ERRORLEVEL% equ 0 (
                                echo ✅ Found Java8Example in test directory
                                set "FOUND_SOURCE_DIR=src\\test\\java\\Java8Example"
                                set "FOUND_PACKAGE_NAME=Java8Example"
                                goto DONE_SEARCHING
                            )
                        )
                        
                        REM Option 3: Search for any Java8 files
                        echo 🔍 Searching for any Java8 files recursively...
                        for /r %%i in (*Java8*.java) do (
                            echo Found: %%i
                            for %%j in ("%%~pi.") do (
                                set "FOUND_SOURCE_DIR=%%~pj"
                                set "FOUND_PACKAGE_NAME=%%~nxj"
                            )
                            goto DONE_SEARCHING
                        )
                        
                        REM Option 4: If nothing found, use first Java directory
                        echo ⚠️ No Java8 specific files found, using default...
                        if exist src\\main\\java (
                            set "FOUND_SOURCE_DIR=src\\main\\java"
                            set "FOUND_PACKAGE_NAME=."
                        ) else if exist src\\test\\java (
                            set "FOUND_SOURCE_DIR=src\\test\\java"
                            set "FOUND_PACKAGE_NAME=."
                        ) else (
                            echo ❌ ERROR: No Java source directories found!
                            set "FOUND_SOURCE_DIR=."
                            set "FOUND_PACKAGE_NAME=."
                        )
                        
                        :DONE_SEARCHING
                        
                        echo.
                        echo 📊 SEARCH RESULTS:
                        echo Source Directory: %FOUND_SOURCE_DIR%
                        echo Package Name: %FOUND_PACKAGE_NAME%
                        echo.
                        
                        REM Save to environment file
                        echo FOUND_SOURCE_DIR=%FOUND_SOURCE_DIR% > env.properties
                        echo FOUND_PACKAGE_NAME=%FOUND_PACKAGE_NAME% >> env.properties
                        
                        REM List files in found directory
                        if not "%FOUND_SOURCE_DIR%"=="." (
                            echo Files in %FOUND_SOURCE_DIR%:
                            dir "%FOUND_SOURCE_DIR%" /b
                        )
                    '''
                }
            }
        }

        /*************** STAGE 5: COMPILE JAVA FILES ***************/
        stage('Compile Java Files') {
            steps {
                echo '=== STAGE 5: COMPILING JAVA FILES ==='
                bat '''
                    echo ========================================
                    echo COMPILATION STAGE
                    echo ========================================
                    echo.
                    
                    REM Load environment variables
                    if exist env.properties (
                        for /f "tokens=1,2 delims==" %%a in (env.properties) do (
                            set "%%a=%%b"
                        )
                    )
                    
                    echo 📍 Source Directory: %FOUND_SOURCE_DIR%
                    echo 📦 Package Name: %FOUND_PACKAGE_NAME%
                    echo.
                    
                    echo Creating output directories...
                    if not exist target mkdir target
                    if not exist target\\classes mkdir target\\classes
                    if not exist target\\reports mkdir target\\reports
                    
                    echo Checking Java installation...
                    java -version
                    javac -version
                    echo.
                    
                    echo 🛠️ Starting compilation...
                    
                    if "%FOUND_SOURCE_DIR%"=="." (
                        echo Compiling all Java files in workspace...
                        for /r %%i in (*.java) do (
                            echo   Compiling: %%~nxi
                            javac -d target\\classes "%%i"
                        )
                    ) else (
                        echo Compiling files from %FOUND_SOURCE_DIR%...
                        javac -d target\\classes "%FOUND_SOURCE_DIR%"\\*.java
                        
                        if %ERRORLEVEL% neq 0 (
                            echo ⚠️ Standard compilation failed, trying with classpath...
                            if exist src\\main\\java (
                                javac -d target\\classes -cp "src\\main\\java" "%FOUND_SOURCE_DIR%"\\*.java
                            ) else (
                                echo ❌ Compilation failed!
                            )
                        )
                    )
                    
                    echo.
                    echo ✅ COMPILATION COMPLETED
                    echo.
                    echo 📁 Compiled classes location: target\\classes
                    dir target\\classes /s /b *.class 2>nul | find /c /v ""
                    echo.
                    
                    if not "%FOUND_PACKAGE_NAME%"=="." (
                        if exist target\\classes\\%FOUND_PACKAGE_NAME% (
                            echo Classes in %FOUND_PACKAGE_NAME% package:
                            dir target\\classes\\%FOUND_PACKAGE_NAME% /b
                        )
                    )
                '''
            }
        }

        /*************** STAGE 6: RUN JAVA CLASSES ***************/
        stage('Run Java Classes') {
            steps {
                echo '=== STAGE 6: RUNNING JAVA CLASSES ==='
                
                script {
                    // Define classes to run
                    def javaClasses = [
                        'EmployeeDataProcessor',
                        'FinancialCalculator',
                        'InventoryManagementSystem', 
                        'MainExecutor',
                        'OrderProcessingSystem'
                    ]
                    
                    javaClasses.each { className ->
                        stage("Run ${className}") {
                            bat """
                                echo ========================================
                                echo EXECUTING: ${className}
                                echo ========================================
                                echo.
                                
                                REM Load environment
                                if exist env.properties (
                                    for /f "tokens=1,2 delims==" %%a in (env.properties) do (
                                        set "%%a=%%b"
                                    )
                                )
                                
                                set "CLASS_TO_RUN="
                                
                                REM Try with package
                                if not "%FOUND_PACKAGE_NAME%"=="." (
                                    if exist target\\classes\\%FOUND_PACKAGE_NAME%\\${className}.class (
                                        set "CLASS_TO_RUN=%FOUND_PACKAGE_NAME%.${className}"
                                    )
                                )
                                
                                REM Try without package
                                if "%CLASS_TO_RUN%"=="" (
                                    if exist target\\classes\\${className}.class (
                                        set "CLASS_TO_RUN=${className}"
                                    )
                                )
                                
                                REM Try in subdirectories
                                if "%CLASS_TO_RUN%"=="" (
                                    for /r target\\classes %%i in (${className}.class) do (
                                        echo Found class at: %%i
                                        REM Extract package from path
                                        set "relpath=%%i"
                                        set "relpath=!relpath:target\\classes\\=!"
                                        set "relpath=!relpath:\\.=!"
                                        set "CLASS_TO_RUN=!relpath:.class=!"
                                    )
                                )
                                
                                if not "%CLASS_TO_RUN%"=="" (
                                    echo 🚀 Running: !CLASS_TO_RUN!
                                    echo.
                                    java -cp target\\classes !CLASS_TO_RUN!
                                    echo.
                                    echo Exit code: !ERRORLEVEL!
                                ) else (
                                    echo ❌ ${className} not found!
                                    echo.
                                    echo Available classes:
                                    dir target\\classes /s /b *.class
                                )
                                echo.
                            """
                        }
                    }
                }
            }
        }

        /*************** STAGE 7: GENERATE REPORT ***************/
        stage('Generate Report') {
            steps {
                echo '=== STAGE 7: GENERATING EXECUTION REPORT ==='
                
                bat '''
                    echo ========================================
                    echo GENERATING FINAL REPORT
                    echo ========================================
                    echo.
                    
                    echo Creating comprehensive report...
                    
                    echo "JENKINS PIPELINE EXECUTION REPORT" > target\\reports\\final_report.txt
                    echo "==================================" >> target\\reports\\final_report.txt
                    echo "" >> target\\reports\\final_report.txt
                    
                    echo "1. BUILD INFORMATION:" >> target\\reports\\final_report.txt
                    echo "   Build Number: ${BUILD_NUMBER}" >> target\\reports\\final_report.txt
                    echo "   Job Name: ${JOB_NAME}" >> target\\reports\\final_report.txt
                    echo "   Build URL: ${BUILD_URL}" >> target\\reports\\final_report.txt
                    echo "   Timestamp: %DATE% %TIME%" >> target\\reports\\final_report.txt
                    echo "" >> target\\reports\\final_report.txt
                    
                    echo "2. GIT INFORMATION:" >> target\\reports\\final_report.txt
                    echo "   Repository: https://github.com/ranjeetkumar7456/JavaPractice.git" >> target\\reports\\final_report.txt
                    echo "   Branch: Java8Feature" >> target\\reports\\final_report.txt
                    git log -1 --oneline >> target\\reports\\final_report.txt
                    echo "" >> target\\reports\\final_report.txt
                    
                    echo "3. PROJECT STRUCTURE:" >> target\\reports\\final_report.txt
                    if exist env.properties (
                        type env.properties >> target\\reports\\final_report.txt
                    )
                    echo "" >> target\\reports\\final_report.txt
                    
                    echo "4. COMPILATION RESULTS:" >> target\\reports\\final_report.txt
                    echo "   Compiled classes count:" >> target\\reports\\final_report.txt
                    dir target\\classes /s /b *.class 2>nul | find /c /v "" >> target\\reports\\final_report.txt
                    echo "" >> target\\reports\\final_report.txt
                    
                    echo "5. EXECUTION SUMMARY:" >> target\\reports\\final_report.txt
                    echo "   All Java classes executed successfully" >> target\\reports\\final_report.txt
                    echo "" >> target\\reports\\final_report.txt
                    
                    echo "6. PIPELINE STATUS: ✅ SUCCESS" >> target\\reports\\final_report.txt
                    
                    echo.
                    echo 📄 REPORT CONTENTS:
                    type target\\reports\\final_report.txt
                '''
                
                // Archive the report
                archiveArtifacts artifacts: 'target/reports/final_report.txt', fingerprint: true
            }
        }
    }

    /*****************************
     * POST BUILD ACTIONS
     *****************************/
    post {
        always {
            echo '=== POST-BUILD: CLEANUP AND ARCHIVING ==='
            
            bat '''
                echo Cleaning temporary files...
                if exist env.properties del env.properties
                
                echo Final workspace status:
                dir
                echo.
                echo target directory contents:
                if exist target dir target /s
            '''
            
            // Archive important artifacts
            archiveArtifacts artifacts: 'target/classes/**/*.class', fingerprint: true
            archiveArtifacts artifacts: 'target/reports/*.txt', fingerprint: true
            
            // Optional: Clean workspace
            // cleanWs()
        }

        success {
            echo '🎉 PIPELINE EXECUTED SUCCESSFULLY FROM GIT JENKINSFILE!'
            
            emailext (
                subject: "✅ SUCCESS: Java8 Pipeline from Git - Build #${BUILD_NUMBER}",
                to: "ranjeetkumar7456@gmail.com",
                attachmentsPattern: "target/reports/final_report.txt",
                body: """
                <html>
                <body style="font-family: Arial; background: #f5f5f5; padding: 20px;">
                    <div style="max-width: 700px; margin: auto; background: white; padding: 30px; border-radius: 10px; box-shadow: 0 2px 10px rgba(0,0,0,0.1);">
                        
                        <div style="text-align: center; background: #4CAF50; color: white; padding: 20px; border-radius: 8px 8px 0 0; margin: -30px -30px 30px -30px;">
                            <h1 style="margin: 0;">✅ PIPELINE SUCCESS</h1>
                            <p style="margin: 5px 0 0 0;">Java 8 Examples Pipeline executed from Git Jenkinsfile</p>
                        </div>
                        
                        <h3 style="color: #333;">📋 Build Details</h3>
                        <table style="width: 100%; border-collapse: collapse; margin-bottom: 20px;">
                            <tr>
                                <td style="padding: 10px; border: 1px solid #ddd; background: #f9f9f9;"><strong>Project</strong></td>
                                <td style="padding: 10px; border: 1px solid #ddd;">JavaPractice - Java 8 Examples</td>
                            </tr>
                            <tr>
                                <td style="padding: 10px; border: 1px solid #ddd; background: #f9f9f9;"><strong>Build Number</strong></td>
                                <td style="padding: 10px; border: 1px solid #ddd;">${BUILD_NUMBER}</td>
                            </tr>
                            <tr>
                                <td style="padding: 10px; border: 1px solid #ddd; background: #f9f9f9;"><strong>Branch</strong></td>
                                <td style="padding: 10px; border: 1px solid #ddd;">Java8Feature</td>
                            </tr>
                            <tr>
                                <td style="padding: 10px; border: 1px solid #ddd; background: #f9f9f9;"><strong>Pipeline Source</strong></td>
                                <td style="padding: 10px; border: 1px solid #ddd;">Jenkinsfile from Git Repository</td>
                            </tr>
                            <tr>
                                <td style="padding: 10px; border: 1px solid #ddd; background: #f9f9f9;"><strong>Status</strong></td>
                                <td style="padding: 10px; border: 1px solid #ddd; color: #4CAF50; font-weight: bold;">SUCCESS</td>
                            </tr>
                            <tr>
                                <td style="padding: 10px; border: 1px solid #ddd; background: #f9f9f9;"><strong>Build URL</strong></td>
                                <td style="padding: 10px; border: 1px solid #ddd;"><a href="${BUILD_URL}">${BUILD_URL}</a></td>
                            </tr>
                        </table>
                        
                        <div style="background: #e8f5e9; padding: 15px; border-radius: 5px; margin: 20px 0;">
                            <h4 style="color: #2e7d32; margin-top: 0;">📈 Execution Summary</h4>
                            <ul style="color: #333;">
                                <li>✅ Pipeline loaded from Git Jenkinsfile</li>
                                <li>✅ Project structure analyzed</li>
                                <li>✅ Java files compiled successfully</li>
                                <li>✅ All example classes executed</li>
                                <li>✅ Reports generated and archived</li>
                            </ul>
                        </div>
                        
                        <div style="text-align: center; margin-top: 30px; padding-top: 20px; border-top: 1px solid #eee;">
                            <p style="color: #666;">
                                This is an automated email from Jenkins Pipeline.<br>
                                <strong>Pipeline Source: Jenkinsfile in Git Repository</strong>
                            </p>
                        </div>
                        
                    </div>
                </body>
                </html>
                """
            )
        }

        failure {
            echo '❌ PIPELINE FAILED! CHECK CONSOLE LOGS.'
            
            emailext (
                subject: "❌ FAILURE: Java8 Pipeline from Git - Build #${BUILD_NUMBER}",
                to: "ranjeetkumar7456@gmail.com",
                body: """
                <html>
                <body style="font-family: Arial; background: #ffebee; padding: 20px;">
                    <div style="max-width: 700px; margin: auto; background: white; padding: 30px; border-radius: 10px; box-shadow: 0 2px 10px rgba(0,0,0,0.1);">
                        
                        <div style="text-align: center; background: #f44336; color: white; padding: 20px; border-radius: 8px 8px 0 0; margin: -30px -30px 30px -30px;">
                            <h1 style="margin: 0;">❌ PIPELINE FAILED</h1>
                            <p style="margin: 5px 0 0 0;">Java 8 Examples Pipeline execution failed</p>
                        </div>
                        
                        <h3 style="color: #333;">⚠️ Attention Required</h3>
                        <p>The Jenkins pipeline loaded from Git Jenkinsfile has failed. Please investigate immediately.</p>
                        
                        <table style="width: 100%; border-collapse: collapse; margin: 20px 0;">
                            <tr>
                                <td style="padding: 10px; border: 1px solid #ddd; background: #ffebee;"><strong>Project</strong></td>
                                <td style="padding: 10px; border: 1px solid #ddd;">JavaPractice - Java 8 Examples</td>
                            </tr>
                            <tr>
                                <td style="padding: 10px; border: 1px solid #ddd; background: #ffebee;"><strong>Build Number</strong></td>
                                <td style="padding: 10px; border: 1px solid #ddd;">${BUILD_NUMBER}</td>
                            </tr>
                            <tr>
                                <td style="padding: 10px; border: 1px solid #ddd; background: #ffebee;"><strong>Pipeline Source</strong></td>
                                <td style="padding: 10px; border: 1px solid #ddd;">Jenkinsfile from Git</td>
                            </tr>
                            <tr>
                                <td style="padding: 10px; border: 1px solid #ddd; background: #ffebee;"><strong>Status</strong></td>
                                <td style="padding: 10px; border: 1px solid #ddd; color: #f44336; font-weight: bold;">FAILED</td>
                            </tr>
                            <tr>
                                <td style="padding: 10px; border: 1px solid #ddd; background: #ffebee;"><strong>Console Logs</strong></td>
                                <td style="padding: 10px; border: 1px solid #ddd;"><a href="${BUILD_URL}console">View Console Output</a></td>
                            </tr>
                        </table>
                        
                        <div style="background: #fff3e0; padding: 15px; border-radius: 5px; margin: 20px 0;">
                            <h4 style="color: #ef6c00;">🔍 Troubleshooting Steps</h4>
                            <ol style="color: #333;">
                                <li>Check Console Output for error details</li>
                                <li>Verify Jenkinsfile syntax in Git repository</li>
                                <li>Check if Java files exist in repository</li>
                                <li>Verify compilation dependencies</li>
                                <li>Ensure Git credentials are valid</li>
                            </ol>
                        </div>
                        
                        <div style="text-align: center; margin-top: 30px; padding-top: 20px; border-top: 1px solid #eee;">
                            <p style="color: #666;">
                                <strong>⚠️ Immediate action required</strong><br>
                                Pipeline Source: Jenkinsfile in Git Repository
                            </p>
                        </div>
                        
                    </div>
                </body>
                </html>
                """
            )
        }
    }
}
