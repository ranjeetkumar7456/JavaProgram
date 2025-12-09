pipeline {
    agent any

    triggers {
        // Run every 1 minute
        cron('* * * * *')
    }

    options {
        timestamps()
        disableConcurrentBuilds()
    }

    stages {

        stage('Checkout Code') {
            steps {
                echo '=== CHECKOUT CODE FROM GITHUB USING PERSONAL ACCESS TOKEN (PAT) ==='
                script {
                    // Git से Jenkinsfile खुद checkout हो जाएगा
                    echo "Current directory: ${WORKSPACE}"
                    echo "Jenkinsfile location: ${WORKSPACE}/Jenkinsfile"
                    
                    // Verify project structure
                    bat '''
                        echo ========== PROJECT STRUCTURE ==========
                        dir /s /b *.java || echo No Java files in root
                        
                        echo ========== CHECKING SRC DIRECTORIES ==========
                        if exist src\\main\\java (
                            echo Main Java source exists
                            dir src\\main\\java /s /b *.java
                        ) else (
                            echo src\\main\\java not found
                        )
                        
                        if exist src\\test\\java (
                            echo Test Java source exists
                            dir src\\test\\java /s /b *.java
                        ) else (
                            echo src\\test\\java not found
                        )
                        
                        echo ========== COMPLETE TREE ==========
                        tree /F /A
                    '''
                }
            }
        }

        stage('Find Java8 Examples') {
            steps {
                echo '=== SEARCHING FOR JAVA 8 EXAMPLE FILES ==='
                bat '''
                    echo Searching for Java files with Java8 in name...
                    dir /s /b *Java8* 2>nul || echo No Java8 files found
                    
                    echo Searching in entire workspace...
                    for /r %%i in (*.java) do (
                        echo Found: %%i
                    )
                    
                    echo Checking specific locations...
                    
                    REM Check if Java8Examples exists in main
                    if exist src\\main\\java\\Java8Examples (
                        echo Java8Examples found in main!
                        dir src\\main\\java\\Java8Examples\\*.java /b
                        echo.
                        echo Setting source directory to main...
                        set SOURCE_DIR=src\\main\\java\\Java8Examples
                        set PACKAGE_NAME=Java8Examples
                    ) else (
                        echo Java8Examples NOT found in main
                    )
                    
                    REM Check if Java8Example exists in test
                    if exist src\\test\\java\\Java8Example (
                        echo Java8Example found in test!
                        dir src\\test\\java\\Java8Example\\*.java /b
                        echo.
                        echo Setting source directory to test...
                        set SOURCE_DIR=src\\test\\java\\Java8Example
                        set PACKAGE_NAME=Java8Example
                    ) else (
                        echo Java8Example NOT found in test
                    )
                    
                    if not defined SOURCE_DIR (
                        echo ERROR: No Java8 source directory found!
                        echo Creating empty bin directory and continuing...
                        if not exist bin mkdir bin
                        exit /b 0
                    )
                    
                    echo Using source directory: %SOURCE_DIR%
                    echo Using package name: %PACKAGE_NAME%
                '''
            }
        }

        stage('Compile Java8 Classes') {
            steps {
                echo '=== COMPILING JAVA 8 CLASSES ==='
                bat '''
                    echo Creating bin directory...
                    if not exist bin mkdir bin
                    
                    echo Looking for source files...
                    if defined SOURCE_DIR (
                        echo Compiling from %SOURCE_DIR%...
                        javac -d bin %SOURCE_DIR%\\*.java
                        
                        if %ERRORLEVEL% neq 0 (
                            echo Compilation failed! Trying alternative...
                            REM Try with classpath
                            if exist src\\main\\java (
                                javac -d bin -cp "src\\main\\java" %SOURCE_DIR%\\*.java
                            )
                        )
                    ) else (
                        echo No source directory defined, checking common locations...
                        
                        REM Try main directory
                        if exist src\\main\\java\\Java8Examples\\*.java (
                            echo Compiling from main\\Java8Examples...
                            javac -d bin src\\main\\java\\Java8Examples\\*.java
                            set PACKAGE_NAME=Java8Examples
                        ) else if exist src\\test\\java\\Java8Example\\*.java (
                            echo Compiling from test\\Java8Example...
                            javac -d bin src\\test\\java\\Java8Example\\*.java
                            set PACKAGE_NAME=Java8Example
                        ) else (
                            echo No Java files found in expected locations
                            echo Searching for any Java files...
                            for /r %%i in (*.java) do (
                                echo Would compile: %%i
                            )
                        )
                    )
                    
                    echo Checking compiled classes...
                    if exist bin (
                        if defined PACKAGE_NAME (
                            if exist bin\\%PACKAGE_NAME% (
                                echo Compiled classes in %PACKAGE_NAME% package:
                                dir bin\\%PACKAGE_NAME% /b
                            )
                        )
                        echo All classes in bin:
                        dir bin /s /b *.class
                    )
                '''
            }
        }

        stage('Run Java8 Examples') {
            steps {
                echo '=== RUNNING JAVA 8 EXAMPLE CLASSES ==='
                
                script {
                    // Classes to attempt to run
                    def classesToRun = [
                        'EmployeeDataProcessor',
                        'FinancialCalculator',
                        'InventoryManagementSystem',
                        'MainExecutor',
                        'OrderProcessingSystem'
                    ]
                    
                    classesToRun.each { className ->
                        stage("Run ${className}") {
                            bat """
                                echo Trying to run ${className}...
                                
                                REM Try with detected package name
                                if defined PACKAGE_NAME (
                                    if exist bin\\%PACKAGE_NAME%\\${className}.class (
                                        echo Running %PACKAGE_NAME%.${className}...
                                        java -cp bin %PACKAGE_NAME%.${className}
                                    ) else (
                                        echo ${className}.class not found in %PACKAGE_NAME% package
                                    )
                                ) else (
                                    REM Try both possible packages
                                    if exist bin\\Java8Examples\\${className}.class (
                                        echo Running Java8Examples.${className}...
                                        java -cp bin Java8Examples.${className}
                                    ) else if exist bin\\Java8Example\\${className}.class (
                                        echo Running Java8Example.${className}...
                                        java -cp bin Java8Example.${className}
                                    ) else (
                                        echo ${className}.class not found anywhere in bin
                                        echo Checking if it exists without package...
                                        if exist bin\\${className}.class (
                                            echo Running ${className}...
                                            java -cp bin ${className}
                                        )
                                    )
                                )
                            """
                        }
                    }
                }
            }
        }

        stage('Generate Report') {
            steps {
                echo '=== GENERATING EXECUTION REPORT ==='
                bat '''
                    echo ========== EXECUTION SUMMARY ==========
                    echo Build: ${BUILD_NUMBER}
                    echo Workspace: ${WORKSPACE}
                    echo Time: %DATE% %TIME%
                    
                    echo Creating summary file...
                    echo "Java 8 Examples Execution Report" > execution_report.txt
                    echo "Build: ${BUILD_NUMBER}" >> execution_report.txt
                    echo "Time: %DATE% %TIME%" >> execution_report.txt
                    echo "" >> execution_report.txt
                    
                    echo "Compiled Classes:" >> execution_report.txt
                    if exist bin (
                        dir bin /s /b *.class >> execution_report.txt
                    )
                    
                    type execution_report.txt
                '''
                
                // Archive the report
                archiveArtifacts artifacts: 'execution_report.txt', fingerprint: true
            }
        }
    }

    post {
        always {
            echo '=== PIPELINE COMPLETE ==='
            
            // Archive compiled classes if they exist
            archiveArtifacts artifacts: 'bin/**/*.class', fingerprint: true
            
            // Cleanup if needed
            bat '''
                echo Final workspace contents:
                dir
            '''
        }

        success {
            echo '✅ Pipeline executed successfully!'
            
            emailext (
                subject: "✅ Java 8 Examples Pipeline Success - Build #${BUILD_NUMBER}",
                body: """
                <html>
                <body style="font-family: Arial; padding:15px;">
                    <h2 style="color:green;">Java 8 Examples Pipeline Success</h2>
                    
                    <table border="1" cellpadding="6">
                        <tr><td><b>Project</b></td><td>JavaPractice</td></tr>
                        <tr><td><b>Branch</b></td><td>Java8Feature</td></tr>
                        <tr><td><b>Build Number</b></td><td>${BUILD_NUMBER}</td></tr>
                        <tr><td><b>Build URL</b></td><td><a href="${BUILD_URL}">${BUILD_URL}</a></td></tr>
                        <tr><td><b>Source</b></td><td>Jenkinsfile from Git</td></tr>
                    </table>
                    
                    <p>Pipeline executed from Jenkinsfile in Git repository.</p>
                </body>
                </html>
                """,
                to: "ranjeetkumar7456@gmail.com",
                attachmentsPattern: "execution_report.txt"
            )
        }

        failure {
            echo '❌ Pipeline failed!'
            
            emailext (
                subject: "❌ Java 8 Examples Pipeline Failed - Build #${BUILD_NUMBER}",
                body: """
                <html>
                <body style="font-family: Arial; padding:15px; background:#ffe6e6;">
                    <h2 style="color:red;">Java 8 Examples Pipeline Failed</h2>
                    
                    <table border="1" cellpadding="6">
                        <tr><td><b>Project</b></td><td>JavaPractice</td></tr>
                        <tr><td><b>Branch</b></td><td>Java8Feature</td></tr>
                        <tr><td><b>Build Number</b></td><td>${BUILD_NUMBER}</td></tr>
                        <tr><td><b>Build URL</b></td><td><a href="${BUILD_URL}">${BUILD_URL}</a></td></tr>
                        <tr><td><b>Source</b></td><td>Jenkinsfile from Git</td></tr>
                    </table>
                    
                    <p>Check console output: ${BUILD_URL}console</p>
                </body>
                </html>
                """,
                to: "ranjeetkumar7456@gmail.com"
            )
        }
    }
}
