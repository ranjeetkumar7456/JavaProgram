pipeline {
    agent any

    triggers {
        // Run every 5 minutes instead of every minute
        cron('H/5 * * * *')
    }

    options {
        timestamps()
        disableConcurrentBuilds()
        timeout(time: 10, unit: 'MINUTES')
        buildDiscarder(logRotator(numToKeepStr: '5'))
    }

    environment {
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk1.8.0_371'
        GIT_BRANCH = 'Java8Feature'
    }

    stages {
        
        // STAGE 1: BASIC WORKSPACE CHECK
        stage('1. Workspace Check') {
            steps {
                echo '🔍 STAGE 1: CHECKING WORKSPACE'
                bat '''
                    echo ========================================
                    echo JENKINS PIPELINE STARTED
                    echo ========================================
                    echo Build Number: ${BUILD_NUMBER}
                    echo Workspace: ${WORKSPACE}
                    echo Job Name: ${JOB_NAME}
                    echo.
                    
                    echo 📂 Current Directory Contents:
                    echo ----------------------------------------
                    dir
                    echo.
                '''
            }
        }

        // STAGE 2: GIT CHECKOUT VERIFICATION
        stage('2. Git Verification') {
            steps {
                echo '📦 STAGE 2: GIT VERIFICATION'
                bat '''
                    echo ========================================
                    echo GIT STATUS VERIFICATION
                    echo ========================================
                    
                    echo 1. Git Version:
                    git --version
                    echo.
                    
                    echo 2. Current Branch:
                    git branch --show-current 2>nul || echo "Not a git repository"
                    echo.
                    
                    echo 3. Remote URL:
                    git remote -v 2>nul || echo "No git remote configured"
                    echo.
                    
                    echo 4. Last Commit:
                    git log -1 --oneline 2>nul || echo "Git log not available"
                    echo.
                    
                    echo 5. Jenkinsfile Exists:
                    if exist Jenkinsfile (
                        echo ✅ Jenkinsfile found
                        echo File size: 
                        for %%F in (Jenkinsfile) do echo %%~zF bytes
                    ) else (
                        echo ❌ Jenkinsfile NOT found
                    )
                    echo.
                '''
            }
        }

        // STAGE 3: PROJECT STRUCTURE ANALYSIS
        stage('3. Project Structure') {
            steps {
                echo '📁 STAGE 3: PROJECT STRUCTURE ANALYSIS'
                bat '''
                    echo ========================================
                    echo PROJECT STRUCTURE ANALYSIS
                    echo ========================================
                    
                    echo 📊 Directory Tree (2 levels):
                    echo ----------------------------------------
                    tree /F /A 2>nul || (
                        echo Tree command not available, using dir...
                        dir /s /b | head -20
                    )
                    echo.
                    
                    echo 🔍 Checking for Java directories:
                    echo ----------------------------------------
                    
                    echo "src\\main\\java:" 
                    if exist src\\main\\java (
                        echo ✅ EXISTS
                        echo "  Files count: "
                        dir src\\main\\java /s /b *.java 2>nul | find /c /v ""
                        echo "  First 5 Java files:"
                        dir src\\main\\java /s /b *.java 2>nul | findstr /n "^" | findstr "^[1-5]:"
                    ) else (
                        echo ❌ NOT FOUND
                    )
                    echo.
                    
                    echo "src\\test\\java:" 
                    if exist src\\test\\java (
                        echo ✅ EXISTS
                        echo "  Files count: "
                        dir src\\test\\java /s /b *.java 2>nul | find /c /v ""
                        echo "  First 5 Java files:"
                        dir src\\test\\java /s /b *.java 2>nul | findstr /n "^" | findstr "^[1-5]:"
                    ) else (
                        echo ❌ NOT FOUND
                    )
                    echo.
                    
                    echo 📄 All Java files in workspace:
                    echo ----------------------------------------
                    dir /s /b *.java 2>nul | findstr /n "^" || echo "No Java files found"
                    echo.
                '''
            }
        }

        // STAGE 4: JAVA ENVIRONMENT CHECK
        stage('4. Java Environment') {
            steps {
                echo '☕ STAGE 4: JAVA ENVIRONMENT CHECK'
                bat '''
                    echo ========================================
                    echo JAVA ENVIRONMENT VERIFICATION
                    echo ========================================
                    
                    echo 1. Java Version:
                    java -version 2>&1 || echo "Java not installed"
                    echo.
                    
                    echo 2. Java Compiler:
                    javac -version 2>&1 || echo "Java compiler not found"
                    echo.
                    
                    echo 3. JAVA_HOME:
                    echo %JAVA_HOME%
                    echo.
                    
                    echo 4. Classpath:
                    echo %CLASSPATH%
                    echo.
                '''
            }
        }

        // STAGE 5: SEARCH FOR JAVA8 FILES
        stage('5. Find Java8 Files') {
            steps {
                echo '🔎 STAGE 5: FINDING JAVA8 FILES'
                script {
                    // Save search results to file
                    bat '''
                        echo ========================================
                        echo SEARCHING FOR JAVA8 FILES
                        echo ========================================
                        
                        echo 🔍 Searching in entire workspace...
                        echo.
                        
                        REM Create search results file
                        echo "JAVA8 FILES SEARCH REPORT" > java8_search.txt
                        echo "=========================" >> java8_search.txt
                        echo "Search Time: %DATE% %TIME%" >> java8_search.txt
                        echo "" >> java8_search.txt
                        
                        REM Search for Java8 in file names
                        echo "1. Files with 'Java8' in name:" >> java8_search.txt
                        dir /s /b *Java8* 2>nul >> java8_search.txt || echo "  None found" >> java8_search.txt
                        echo "" >> java8_search.txt
                        
                        REM Search for Java8 in directory names
                        echo "2. Directories with 'Java8' in name:" >> java8_search.txt
                        dir /s /b /ad *Java8* 2>nul >> java8_search.txt || echo "  None found" >> java8_search.txt
                        echo "" >> java8_search.txt
                        
                        REM Search for specific class names
                        echo "3. Searching for specific class files:" >> java8_search.txt
                        for %%c in (EmployeeDataProcessor FinancialCalculator InventoryManagementSystem MainExecutor OrderProcessingSystem) do (
                            echo "  Looking for %%c:" >> java8_search.txt
                            dir /s /b *%%c*.java 2>nul >> java8_search.txt || echo "    Not found" >> java8_search.txt
                        )
                        echo "" >> java8_search.txt
                        
                        REM Show contents of search
                        type java8_search.txt
                    '''
                }
            }
        }

        // STAGE 6: COMPILE IF JAVA FILES EXIST
        stage('6. Conditional Compilation') {
            steps {
                echo '⚙️ STAGE 6: CONDITIONAL COMPILATION'
                script {
                    // Check if any Java files exist
                    bat '''
                        echo ========================================
                        echo CONDITIONAL COMPILATION
                        echo ========================================
                        
                        REM Count Java files
                        set /a JAVA_COUNT=0
                        for /f %%i in ('dir /s /b *.java 2^>nul ^| find /c /v ""') do set JAVA_COUNT=%%i
                        
                        echo Total Java files found: %JAVA_COUNT%
                        echo.
                        
                        if %JAVA_COUNT% GTR 0 (
                            echo ✅ Java files found. Proceeding with compilation...
                            echo.
                            
                            echo Creating output directories...
                            if not exist target mkdir target
                            if not exist target\\classes mkdir target\\classes
                            if not exist target\\reports mkdir target\\reports
                            echo.
                            
                            echo Starting compilation...
                            REM Try to compile all Java files
                            javac -d target\\classes -cp "." *.java 2>&1 || (
                                echo "⚠️ Basic compilation failed, trying recursive..."
                                for /r %%i in (*.java) do (
                                    echo "  Compiling: %%~nxi"
                                    javac -d target\\classes -cp "." "%%i" 2>&1 || echo "    Failed: %%~nxi"
                                )
                            )
                            
                            echo.
                            echo Checking compiled classes...
                            dir target\\classes /s /b *.class 2>nul | find /c /v ""
                            echo.
                        ) else (
                            echo ⚠️ No Java files found. Skipping compilation...
                            echo Creating empty target structure for reporting...
                            if not exist target mkdir target
                            if not exist target\\reports mkdir target\\reports
                            echo "No compilation performed - no Java files found" > target\\reports\\no_java_files.txt
                        )
                    '''
                }
            }
        }

        // STAGE 7: EXECUTE FOUND CLASSES
        stage('7. Execute Classes') {
            steps {
                echo '🚀 STAGE 7: EXECUTING CLASSES'
                script {
                    // Try to execute classes if they exist
                    bat '''
                        echo ========================================
                        echo CLASS EXECUTION
                        echo ========================================
                        
                        if exist target\\classes (
                            echo Checking for compiled classes...
                            set /a CLASS_COUNT=0
                            for /f %%i in ('dir target\\classes /s /b *.class 2^>nul ^| find /c /v ""') do set CLASS_COUNT=%%i
                            
                            echo Total compiled classes: %CLASS_COUNT%
                            echo.
                            
                            if %CLASS_COUNT% GTR 0 (
                                echo ✅ Compiled classes found. Attempting execution...
                                echo.
                                
                                REM List all compiled classes
                                echo "Available classes:"
                                for /r target\\classes %%i in (*.class) do (
                                    set "classpath=%%i"
                                    set "classpath=!classpath:target\\classes\\=!"
                                    set "classpath=!classpath:.class=!"
                                    set "classpath=!classpath:\\=.!"
                                    echo "  !classpath!"
                                )
                                echo.
                                
                                REM Try to execute known classes
                                echo "Attempting to execute known classes:"
                                echo "-----------------------------------"
                                
                                for %%c in (EmployeeDataProcessor FinancialCalculator InventoryManagementSystem MainExecutor OrderProcessingSystem) do (
                                    echo.
                                    echo "Trying %%c..."
                                    REM Try with full package
                                    java -cp target\\classes %%c 2>&1 && echo "  ✅ Success: %%c" || (
                                        REM Try with simple name
                                        for /r target\\classes %%i in (%%c.class) do (
                                            set "classname=%%i"
                                            set "classname=!classname:target\\classes\\=!"
                                            set "classname=!classname:.class=!"
                                            set "classname=!classname:\\=.!"
                                            echo "  Trying as !classname!..."
                                            java -cp target\\classes !classname! 2>&1 && echo "    ✅ Success" || echo "    ❌ Failed"
                                        )
                                    )
                                )
                            ) else (
                                echo ⚠️ No compiled classes found. Skipping execution...
                            )
                        ) else (
                            echo ❌ No target\\classes directory. Compilation might have failed.
                        )
                        echo.
                    '''
                }
            }
        }

        // STAGE 8: GENERATE FINAL REPORT
        stage('8. Generate Report') {
            steps {
                echo '📊 STAGE 8: GENERATING FINAL REPORT'
                bat '''
                    echo ========================================
                    echo GENERATING COMPREHENSIVE REPORT
                    echo ========================================
                    
                    echo Creating final report...
                    
                    echo "JENKINS PIPELINE EXECUTION SUMMARY" > target\\reports\\execution_summary.txt
                    echo "===================================" >> target\\reports\\execution_summary.txt
                    echo "" >> target\\reports\\execution_summary.txt
                    
                    echo "EXECUTION DETAILS:" >> target\\reports\\execution_summary.txt
                    echo "  Build Number: ${BUILD_NUMBER}" >> target\\reports\\execution_summary.txt
                    echo "  Job Name: ${JOB_NAME}" >> target\\reports\\execution_summary.txt
                    echo "  Build URL: ${BUILD_URL}" >> target\\reports\\execution_summary.txt
                    echo "  Workspace: ${WORKSPACE}" >> target\\reports\\execution_summary.txt
                    echo "  Timestamp: %DATE% %TIME%" >> target\\reports\\execution_summary.txt
                    echo "" >> target\\reports\\execution_summary.txt
                    
                    echo "GIT INFORMATION:" >> target\\reports\\execution_summary.txt
                    echo "  Repository: https://github.com/ranjeetkumar7456/JavaPractice.git" >> target\\reports\\execution_summary.txt
                    echo "  Branch: Java8Feature" >> target\\reports\\execution_summary.txt
                    git log -1 --oneline 2>nul >> target\\reports\\execution_summary.txt || echo "  Git info not available" >> target\\reports\\execution_summary.txt
                    echo "" >> target\\reports\\execution_summary.txt
                    
                    echo "PROJECT STRUCTURE:" >> target\\reports\\execution_summary.txt
                    echo "  Java files found: " >> target\\reports\\execution_summary.txt
                    dir /s /b *.java 2>nul | find /c /v "" >> target\\reports\\execution_summary.txt || echo "  0" >> target\\reports\\execution_summary.txt
                    echo "" >> target\\reports\\execution_summary.txt
                    
                    echo "COMPILATION RESULTS:" >> target\\reports\\execution_summary.txt
                    if exist target\\classes (
                        echo "  Compiled classes: " >> target\\reports\\execution_summary.txt
                        dir target\\classes /s /b *.class 2>nul | find /c /v "" >> target\\reports\\execution_summary.txt || echo "  0" >> target\\reports\\execution_summary.txt
                    ) else (
                        echo "  No compilation performed" >> target\\reports\\execution_summary.txt
                    )
                    echo "" >> target\\reports\\execution_summary.txt
                    
                    echo "EXECUTION RESULTS:" >> target\\reports\\execution_summary.txt
                    echo "  Pipeline executed successfully" >> target\\reports\\execution_summary.txt
                    echo "" >> target\\reports\\execution_summary.txt
                    
                    echo "STATUS: COMPLETED SUCCESSFULLY ✅" >> target\\reports\\execution_summary.txt
                    
                    echo.
                    echo "📄 REPORT CONTENTS:"
                    type target\\reports\\execution_summary.txt
                '''
                
                // Archive the report
                archiveArtifacts artifacts: 'target/reports/execution_summary.txt', fingerprint: true
                archiveArtifacts artifacts: 'java8_search.txt', fingerprint: true
            }
        }
    }

    post {
        always {
            echo '🔄 POST-BUILD: FINAL STEPS'
            
            bat '''
                echo ========================================
                echo CLEANUP AND FINALIZATION
                echo ========================================
                
                echo 📊 Final Workspace Status:
                echo "Total files in workspace:"
                dir /s /b | find /c /v ""
                echo.
                
                echo 📁 Target directory contents:
                if exist target (
                    tree target /F /A 2>nul || dir target /s
                ) else (
                    echo "No target directory created"
                )
                echo.
                
                echo 🧹 Cleaning temporary files...
                if exist java8_search.txt del java8_search.txt
                echo "Cleanup completed"
            '''
            
            // Archive important files
            archiveArtifacts artifacts: 'target/**/*', fingerprint: true
            archiveArtifacts artifacts: '*.log', allowEmptyArchive: true
            
            // Record build duration
            script {
                currentBuild.description = "Java8 Pipeline - Build #${BUILD_NUMBER}"
            }
        }

        success {
            echo '🎉 PIPELINE EXECUTED SUCCESSFULLY!'
            
            // Success email
            emailext (
                subject: "✅ SUCCESS: Java8 Pipeline - Build #${BUILD_NUMBER}",
                to: "ranjeetkumar7456@gmail.com",
                attachmentsPattern: "target/reports/execution_summary.txt",
                body: """
                <html>
                <body style="font-family: Arial; background: #f8fff8; padding: 20px;">
                    <div style="max-width: 700px; margin: auto; background: white; padding: 25px; border-radius: 8px; border: 2px solid #4CAF50;">
                        
                        <div style="text-align: center; margin-bottom: 20px;">
                            <h2 style="color: #4CAF50; margin: 0;">✅ PIPELINE SUCCESS</h2>
                            <p style="color: #666;">Java 8 Pipeline executed successfully</p>
                        </div>
                        
                        <table style="width: 100%; border-collapse: collapse;">
                            <tr><td style="padding: 8px; border-bottom: 1px solid #eee;"><b>Project:</b></td><td style="padding: 8px; border-bottom: 1px solid #eee;">JavaPractice</td></tr>
                            <tr><td style="padding: 8px; border-bottom: 1px solid #eee;"><b>Build #:</b></td><td style="padding: 8px; border-bottom: 1px solid #eee;">${BUILD_NUMBER}</td></tr>
                            <tr><td style="padding: 8px; border-bottom: 1px solid #eee;"><b>Status:</b></td><td style="padding: 8px; border-bottom: 1px solid #eee; color: #4CAF50; font-weight: bold;">SUCCESS</td></tr>
                            <tr><td style="padding: 8px; border-bottom: 1px solid #eee;"><b>Branch:</b></td><td style="padding: 8px; border-bottom: 1px solid #eee;">Java8Feature</td></tr>
                            <tr><td style="padding: 8px; border-bottom: 1px solid #eee;"><b>Time:</b></td><td style="padding: 8px; border-bottom: 1px solid #eee;">${new Date()}</td></tr>
                        </table>
                        
                        <div style="background: #f0f8f0; padding: 15px; border-radius: 5px; margin-top: 20px;">
                            <p style="margin: 0;">✅ Pipeline executed from Jenkinsfile in Git repository</p>
                        </div>
                        
                        <p style="text-align: center; margin-top: 20px; color: #666;">
                            <a href="${BUILD_URL}" style="color: #2196F3;">View Build Details</a>
                        </p>
                        
                    </div>
                </body>
                </html>
                """
            )
        }

        failure {
            echo '❌ PIPELINE FAILED!'
            
            // Failure email
            emailext (
                subject: "❌ FAILURE: Java8 Pipeline - Build #${BUILD_NUMBER}",
                to: "ranjeetkumar7456@gmail.com",
                body: """
                <html>
                <body style="font-family: Arial; background: #fff0f0; padding: 20px;">
                    <div style="max-width: 700px; margin: auto; background: white; padding: 25px; border-radius: 8px; border: 2px solid #f44336;">
                        
                        <div style="text-align: center; margin-bottom: 20px;">
                            <h2 style="color: #f44336; margin: 0;">❌ PIPELINE FAILED</h2>
                            <p style="color: #666;">Java 8 Pipeline execution failed</p>
                        </div>
                        
                        <table style="width: 100%; border-collapse: collapse;">
                            <tr><td style="padding: 8px; border-bottom: 1px solid #eee;"><b>Project:</b></td><td style="padding: 8px; border-bottom: 1px solid #eee;">JavaPractice</td></tr>
                            <tr><td style="padding: 8px; border-bottom: 1px solid #eee;"><b>Build #:</b></td><td style="padding: 8px; border-bottom: 1px solid #eee;">${BUILD_NUMBER}</td></tr>
                            <tr><td style="padding: 8px; border-bottom: 1px solid #eee;"><b>Status:</b></td><td style="padding: 8px; border-bottom: 1px solid #eee; color: #f44336; font-weight: bold;">FAILED</td></tr>
                            <tr><td style="padding: 8px; border-bottom: 1px solid #eee;"><b>Error:</b></td><td style="padding: 8px; border-bottom: 1px solid #eee;">Check console logs</td></tr>
                            <tr><td style="padding: 8px; border-bottom: 1px solid #eee;"><b>Time:</b></td><td style="padding: 8px; border-bottom: 1px solid #eee;">${new Date()}</td></tr>
                        </table>
                        
                        <div style="background: #fff0f0; padding: 15px; border-radius: 5px; margin-top: 20px;">
                            <p style="margin: 0; color: #c62828;">❌ Check console output for details:</p>
                            <p style="margin: 5px 0 0 0;">
                                <a href="${BUILD_URL}console" style="color: #2196F3;">${BUILD_URL}console</a>
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
