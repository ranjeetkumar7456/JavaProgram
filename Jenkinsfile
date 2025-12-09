pipeline {
    agent any

    // हर 5 मिनट पर run होगा
    triggers {
        cron('H/2 * * * *')
    }

    options {
        timestamps()
        disableConcurrentBuilds()
        timeout(time: 15, unit: 'MINUTES')
    }

    environment {
        PROJECT_NAME = "JavaPractice"
        EMAIL_TO = "ranjeetkumar7456@gmail.com"
    }

    stages {

        /*************** STAGE 1: CHECKOUT CODE ***************/
        stage('1. Git Checkout') {
            steps {
                echo '📦 STAGE 1: GIT CHECKOUT'
                script {
                    // Clean और checkout
                    bat '''
                        echo Cleaning workspace...
                        if exist workspace rmdir /s /q workspace
                    '''
                    
                    // Git checkout using credentials
                    checkout([
                        $class: 'GitSCM',
                        branches: [[name: '*/Java8Feature']],
                        extensions: [],
                        userRemoteConfigs: [[
                            url: 'https://github.com/ranjeetkumar7456/JavaPractice.git',
                            credentialsId: 'github-pat'
                        ]]
                    ])
                }
            }
        }

        /*************** STAGE 2: VERIFY FILES ***************/
        stage('2. Verify Files') {
            steps {
                echo '🔍 STAGE 2: VERIFYING FILES'
                bat '''
                    echo ========================================
                    echo PROJECT STRUCTURE
                    echo ========================================
                    
                    echo Current directory: %CD%
                    echo.
                    
                    echo Listing all files:
                    dir
                    echo.
                    
                    echo Checking for Java files:
                    dir /s /b *.java 2>nul || echo "No Java files found"
                    echo.
                    
                    echo Checking for pom.xml:
                    if exist pom.xml (
                        echo ✅ pom.xml found - Maven project
                    ) else (
                        echo ❌ pom.xml not found
                    )
                '''
            }
        }

        /*************** STAGE 3: CHECK JAVA ***************/
        stage('3. Check Java Installation') {
            steps {
                echo '☕ STAGE 3: CHECKING JAVA'
                bat '''
                    echo Java Version:
                    java -version 2>&1 || echo "Java not found"
                    echo.
                    
                    echo Java Compiler:
                    javac -version 2>&1 || echo "Java compiler not found"
                    echo.
                    
                    echo JAVA_HOME:
                    echo %JAVA_HOME%
                '''
            }
        }

        /*************** STAGE 4: COMPILE JAVA FILES ***************/
        stage('4. Compile Java') {
            steps {
                echo '⚙️ STAGE 4: COMPILING JAVA FILES'
                script {
                    bat '''
                        echo Creating output directories...
                        if not exist target mkdir target
                        if not exist target\\classes mkdir target\\classes
                        if not exist target\\reports mkdir target\\reports
                        
                        echo Searching for Java files...
                        set /a JAVA_COUNT=0
                        for /f %%i in ('dir /s /b *.java 2^>nul ^| find /c /v ""') do set JAVA_COUNT=%%i
                        
                        echo Total Java files: %JAVA_COUNT%
                        echo.
                        
                        if %JAVA_COUNT% GTR 0 (
                            echo Compiling Java files...
                            for /r %%i in (*.java) do (
                                echo   Compiling: %%~nxi
                                javac -d target\\classes "%%i" 2>&1 || echo "    ⚠️ Failed: %%~nxi"
                            )
                        ) else (
                            echo No Java files to compile
                        )
                        
                        echo.
                        echo Compiled classes:
                        dir target\\classes /s /b *.class 2>nul | find /c /v "" || echo "0"
                    '''
                }
            }
        }

        /*************** STAGE 5: RUN JAVA CLASSES ***************/
        stage('5. Run Java Programs') {
            steps {
                echo '🚀 STAGE 5: RUNNING JAVA PROGRAMS'
                script {
                    // Try to run common Java 8 example classes
                    def javaClasses = [
                        'EmployeeDataProcessor',
                        'FinancialCalculator',
                        'InventoryManagementSystem',
                        'MainExecutor',
                        'OrderProcessingSystem'
                    ]
                    
                    javaClasses.each { className ->
                        bat """
                            echo.
                            echo Trying to run: ${className}
                            if exist target\\classes\\${className}.class (
                                echo Running ${className}...
                                java -cp target\\classes ${className} 2>&1 || echo "  ❌ Failed to run"
                            ) else (
                                echo ❌ ${className}.class not found
                            )
                        """
                    }
                }
            }
        }

        /*************** STAGE 6: CREATE JAR (Optional) ***************/
        stage('6. Create JAR') {
            steps {
                echo '📦 STAGE 6: CREATING JAR FILE'
                bat '''
                    echo Checking for compiled classes...
                    set /a CLASS_COUNT=0
                    for /f %%i in ('dir target\\classes /s /b *.class 2^>nul ^| find /c /v ""') do set CLASS_COUNT=%%i
                    
                    if %CLASS_COUNT% GTR 0 (
                        echo Creating JAR file...
                        echo Creating manifest...
                        echo "Main-Class: MainExecutor" > manifest.txt
                        echo "Created-By: Jenkins Pipeline" >> manifest.txt
                        
                        echo Building JAR...
                        jar cvfm target\\JavaPractice.jar manifest.txt -C target\\classes .
                        
                        echo JAR created: target\\JavaPractice.jar
                        dir target\\*.jar /b
                    ) else (
                        echo No classes to package, skipping JAR creation
                    )
                '''
            }
        }

        /*************** STAGE 7: GENERATE REPORT ***************/
        stage('7. Generate Report') {
            steps {
                echo '📊 STAGE 7: GENERATING REPORT'
                bat '''
                    echo ========================================
                    echo BUILD SUMMARY REPORT
                    echo ========================================
                    
                    echo Creating report file...
                    
                    echo "JENKINS PIPELINE EXECUTION SUMMARY" > build_report.txt
                    echo "===================================" >> build_report.txt
                    echo "" >> build_report.txt
                    
                    echo "PROJECT INFORMATION:" >> build_report.txt
                    echo "  Project: ${PROJECT_NAME}" >> build_report.txt
                    echo "  Build: #${BUILD_NUMBER}" >> build_report.txt
                    echo "  Job: ${JOB_NAME}" >> build_report.txt
                    echo "  URL: ${BUILD_URL}" >> build_report.txt
                    echo "  Time: %DATE% %TIME%" >> build_report.txt
                    echo "" >> build_report.txt
                    
                    echo "GIT INFORMATION:" >> build_report.txt
                    echo "  Repository: JavaPractice" >> build_report.txt
                    echo "  Branch: Java8Feature" >> build_report.txt
                    echo "" >> build_report.txt
                    
                    echo "COMPILATION RESULTS:" >> build_report.txt
                    echo "  Java files found: " >> build_report.txt
                    dir /s /b *.java 2>nul | find /c /v "" >> build_report.txt || echo "  0" >> build_report.txt
                    echo "  Classes compiled: " >> build_report.txt
                    dir target\\classes /s /b *.class 2>nul | find /c /v "" >> build_report.txt || echo "  0" >> build_report.txt
                    echo "" >> build_report.txt
                    
                    echo "STATUS: ${currentBuild.currentResult}" >> build_report.txt
                    
                    echo.
                    echo Report contents:
                    type build_report.txt
                '''
            }
        }
    }

    /*****************************
     * POST BUILD ACTIONS
     *****************************/
    post {
        always {
            echo '✅ PIPELINE EXECUTION COMPLETED'
            
            // Archive artifacts
            archiveArtifacts artifacts: 'build_report.txt', fingerprint: true
            archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
            archiveArtifacts artifacts: 'target/classes/**/*.class', allowEmptyArchive: true
            
            // Cleanup
            bat '''
                echo Final workspace cleanup...
                echo Workspace size:
                dir /s | find "File(s)"
            '''
        }

        success {
            echo '🎉 BUILD SUCCESSFUL!'
            
            // Simple success email (Email Extension plugin चाहिए)
            script {
                // Try to send email if plugin is available
                try {
                    emailext (
                        subject: "✅ SUCCESS: JavaPractice Pipeline - Build #${BUILD_NUMBER}",
                        to: "${EMAIL_TO}",
                        body: """
                        Pipeline executed successfully.
                        
                        Project: ${PROJECT_NAME}
                        Build: #${BUILD_NUMBER}
                        Status: SUCCESS
                        URL: ${BUILD_URL}
                        """
                    )
                } catch (Exception e) {
                    echo "Email plugin not available, skipping email"
                }
            }
        }

        failure {
            echo '❌ BUILD FAILED!'
            
            // Simple failure notification
            script {
                try {
                    emailext (
                        subject: "❌ FAILED: JavaPractice Pipeline - Build #${BUILD_NUMBER}",
                        to: "${EMAIL_TO}",
                        body: """
                        Pipeline execution failed.
                        
                        Project: ${PROJECT_NAME}
                        Build: #${BUILD_NUMBER}
                        Status: FAILED
                        URL: ${BUILD_URL}
                        Console: ${BUILD_URL}console
                        """
                    )
                } catch (Exception e) {
                    echo "Email plugin not available, skipping email"
                }
            }
        }
    }
}
