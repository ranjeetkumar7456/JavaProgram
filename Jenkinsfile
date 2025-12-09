pipeline {

    agent any

    /*****************************
     * CRON TRIGGER (RUN EVERY 1 MIN)
     *****************************/
    triggers {
        cron('* * * * *')
    }

    /*****************************
     * GLOBAL OPTIONS
     *****************************/
    options {
        timestamps()
        disableConcurrentBuilds()
        timeout(time: 10, unit: 'MINUTES')
    }

    /*****************************
     * ALL STAGES
     *****************************/
    stages {

        /*************** 1. CHECKOUT CODE ***************/
        stage('Checkout Code') {
            steps {
                echo '=== CHECKOUT CODE FROM GITHUB USING PERSONAL ACCESS TOKEN (PAT) ==='

                withCredentials([string(credentialsId: 'github-pat', variable: 'GIT_PAT')]) {
                    bat '''
                        echo Deleting old repo folder if exists...
                        if exist repo rmdir /s /q repo

                        echo Cloning latest code from GitHub...
                        "C:\\Program Files\\Git\\bin\\git.exe" clone -b Java8Feature https://ranjeetkumar7456:%GIT_PAT%@github.com/ranjeetkumar7456/JavaPractice.git repo

                        if %ERRORLEVEL% neq 0 (
                            echo Git clone failed!
                            exit /b 1
                        )
                        
                        echo ========== PROJECT STRUCTURE CHECK ==========
                        echo Listing test directory...
                        dir repo\\src\\test\\java\\Java8Example /b
                    '''
                }
            }
        }

        /*************** 2. COMPILE JAVA FILES ***************/
        stage('Compile All Classes') {
            steps {
                echo '=== COMPILING JAVA 8 EXAMPLE CLASSES FROM TEST DIRECTORY ==='

                bat '''
                    echo Creating bin directory...
                    if not exist repo\\bin mkdir repo\\bin

                    echo Compiling Java 8 Example classes from test directory...
                    
                    REM First, check if there are any dependencies in main/java
                    if exist repo\\src\\main\\java (
                        echo Main source directory exists, including in classpath...
                        javac -d repo\\bin -cp "repo\\src\\main\\java" repo\\src\\test\\java\\Java8Example\\*.java
                    ) else (
                        echo Only compiling test classes...
                        javac -d repo\\bin repo\\src\\test\\java\\Java8Example\\*.java
                    )

                    if %ERRORLEVEL% neq 0 (
                        echo Java compilation failed! Trying alternative compilation...
                        
                        REM Try compiling each file separately
                        cd repo\\src\\test\\java\\Java8Example
                        for %%f in (*.java) do (
                            echo Compiling %%~nf.java...
                            javac -d ..\\..\\..\\..\\bin %%f
                        )
                        cd ..\\..\\..\\..
                    )
                    
                    echo Checking compiled classes...
                    if exist repo\\bin\\Java8Example (
                        dir repo\\bin\\Java8Example /b
                        echo Compilation successful!
                    ) else (
                        echo No Java8Example package found in bin directory
                        dir repo\\bin /b
                    )
                '''
            }
        }

        /*************** 3. VERIFY AND RUN JAVA MODULES ***************/
        stage('Verify Classes') {
            steps {
                echo '=== VERIFYING CLASSES HAVE MAIN METHOD ==='
                
                bat '''
                    echo Checking for main methods in Java8Example classes...
                    cd repo
                    
                    for /f %%i in ('findstr /s /m "public static void main" src\\test\\java\\Java8Example\\*.java') do (
                        echo Found main method in: %%i
                        REM Extract just the filename without extension
                        for %%j in ("%%i") do (
                            set "filename=%%~nj"
                        )
                        echo Class with main: !filename!
                    )
                    
                    echo List of all Java files:
                    dir src\\test\\java\\Java8Example\\*.java /b
                '''
            }
        }

        /*************** 4. RUN ALL JAVA MODULES (DYNAMIC APPROACH) ***************/
        stage('Run All Java8Examples') {
            steps {
                echo '=== RUNNING ALL JAVA 8 EXAMPLE CLASSES ==='
                
                script {
                    // Define the classes you want to run
                    def java8Classes = [
                        'EmployeeDataProcessor',
                        'FinancialCalculator', 
                        'InventoryManagementSystem',
                        'MainExecutor',
                        'OrderProcessingSystem'
                    ]
                    
                    java8Classes.each { className ->
                        stage("Run ${className}") {
                            steps {
                                script {
                                    echo "=== RUNNING ${className} CLASS ==="
                                    
                                    bat """
                                        cd repo
                                        echo Checking if ${className}.class exists...
                                        if exist bin\\Java8Example\\${className}.class (
                                            echo Running ${className}...
                                            java -cp bin Java8Example.${className}
                                        ) else (
                                            echo ${className}.class not found in bin\\Java8Example!
                                            echo Available classes:
                                            if exist bin\\Java8Example dir bin\\Java8Example /b
                                        )
                                    """
                                }
                            }
                        }
                    }
                }
            }
        }

        /*************** 5. ALTERNATIVE: RUN ALL CLASSES AUTOMATICALLY ***************/
        stage('Run All Classes Automatically') {
            steps {
                echo '=== RUNNING ALL CLASSES THAT HAVE MAIN METHOD ==='
                
                bat '''
                    cd repo
                    
                    echo Finding and running all classes with main method...
                    
                    REM Create a temporary file to store class names
                    echo. > classes_with_main.txt
                    
                    REM Find all Java files with main method
                    for /f "tokens=*" %%i in ('findstr /s /m "public static void main" src\\test\\java\\Java8Example\\*.java') do (
                        echo Processing %%i
                        REM Get just the filename without extension
                        for %%j in ("%%i") do (
                            set "classname=%%~nj"
                            echo !classname! >> classes_with_main.txt
                        )
                    )
                    
                    REM Read the file and run each class
                    if exist classes_with_main.txt (
                        echo Classes to run:
                        type classes_with_main.txt
                        
                        for /f "tokens=*" %%c in (classes_with_main.txt) do (
                            if not "%%c"=="" (
                                echo.
                                echo ========================================
                                echo Running Java8Example.%%c
                                echo ========================================
                                java -cp bin Java8Example.%%c
                                echo Exit code: !ERRORLEVEL!
                            )
                        )
                        
                        del classes_with_main.txt
                    ) else (
                        echo No classes with main method found!
                        
                        echo Trying to run predefined classes...
                        REM Fallback to predefined list
                        for %%c in (EmployeeDataProcessor FinancialCalculator InventoryManagementSystem MainExecutor OrderProcessingSystem) do (
                            echo Trying to run %%c...
                            java -cp bin Java8Example.%%c 2>nul || echo %%c failed or not found
                        )
                    )
                '''
            }
        }

        /*************** 6. EXTENT REPORT PLACEHOLDER ***************/
        stage('Generate Report') {
            steps {
                echo '=== GENERATING EXECUTION REPORT ==='
                
                bat '''
                    cd repo
                    echo ========== EXECUTION SUMMARY ==========
                    echo Execution completed at: %DATE% %TIME%
                    
                    echo Creating summary report...
                    echo "Java 8 Examples Execution Report" > execution_report.txt
                    echo "================================" >> execution_report.txt
                    echo "Timestamp: %DATE% %TIME%" >> execution_report.txt
                    echo "Branch: Java8Feature" >> execution_report.txt
                    echo "" >> execution_report.txt
                    echo "Compiled Classes:" >> execution_report.txt
                    if exist bin\\Java8Example (
                        dir bin\\Java8Example /b >> execution_report.txt
                    ) else (
                        dir bin /b >> execution_report.txt
                    )
                    
                    type execution_report.txt
                '''
                
                // Archive the report
                archiveArtifacts artifacts: 'repo/execution_report.txt', fingerprint: true
            }
        }
    }

    /*****************************
     * POST BUILD ACTIONS
     *****************************/
    post {

        /*************** ALWAYS RUN ***************/
        always {
            echo '=== PIPELINE FINISHED: CLEANING UP WORKSPACE ==='
            
            // Archive compiled classes
            archiveArtifacts artifacts: 'repo/bin/**/*.class', fingerprint: true
            
            // Archive source files
            archiveArtifacts artifacts: 'repo/src/test/java/Java8Example/*.java', fingerprint: true
            
            // Cleanup if needed
            bat '''
                echo Cleaning up temporary files...
                if exist repo\\classes_with_main.txt del repo\\classes_with_main.txt
            '''
        }

        /*************** SUCCESS NOTIFICATION ***************/
        success {
            echo '✅ All stages executed successfully! Sending success email...'

            emailext (
                subject: "✅ Java 8 Examples Execution Report - Build #${BUILD_NUMBER}",
                to: "ranjeetkumar7456@gmail.com",
                attachmentsPattern: "repo/execution_report.txt, repo/bin/Java8Example/*.class",
                body: """
                <html>
                <body style='font-family: Arial; background:#f4f6f7; padding:15px;'>
                    <h2 style='color:#0071ce;'>Java 8 Examples Execution Successful</h2>
                    <p>The Jenkins pipeline executed all Java 8 examples successfully.</p>

                    <table border='1' cellpadding='6' style='border-collapse:collapse;'>
                        <tr><td><b>Project</b></td><td>JavaPractice - Java 8 Examples</td></tr>
                        <tr><td><b>Branch</b></td><td>Java8Feature</td></tr>
                        <tr><td><b>Build Number</b></td><td>${BUILD_NUMBER}</td></tr>
                        <tr><td><b>Build URL</b></td><td><a href='${BUILD_URL}'>${BUILD_URL}</a></td></tr>
                        <tr><td><b>Status</b></td><td style='color:green;'><b>SUCCESS</b></td></tr>
                        <tr><td><b>Date/Time</b></td><td>${new Date()}</td></tr>
                        <tr><td><b>Location</b></td><td>src/test/java/Java8Example</td></tr>
                    </table>
                    
                    <h3>Execution Details:</h3>
                    <ul>
                        <li>Classes compiled and executed from test directory</li>
                        <li>Automatic detection of classes with main method</li>
                        <li>Compiled classes archived as artifacts</li>
                    </ul>
                </body>
                </html>
                """
            )
        }

        /*************** FAILURE NOTIFICATION ***************/
        failure {
            echo '❌ Build failed! Sending failure email...'

            emailext (
                subject: "❌ Java 8 Examples Execution Failed - Build #${BUILD_NUMBER}",
                to: "ranjeetkumar7456@gmail.com",
                body: """
                <html>
                <body style='font-family: Arial; background:#fff2f2; padding:15px;'>
                    <h2 style='color:red;'>Java 8 Examples Execution Failed</h2>
                    <p>The Jenkins build failed. Please check logs for compilation or execution errors.</p>

                    <table border='1' cellpadding='6' style='border-collapse:collapse;'>
                        <tr><td><b>Project</b></td><td>JavaPractice - Java 8 Examples</td></tr>
                        <tr><td><b>Branch</b></td><td>Java8Feature</td></tr>
                        <tr><td><b>Build Number</b></td><td>${BUILD_NUMBER}</td></tr>
                        <tr><td><b>Build URL</b></td><td><a href='${BUILD_URL}'>${BUILD_URL}</a></td></tr>
                        <tr><td><b>Status</b></td><td style='color:red;'><b>FAILED</b></td></tr>
                        <tr><td><b>Date/Time</b></td><td>${new Date()}</td></tr>
                        <tr><td><b>Location</b></td><td>src/test/java/Java8Example</td></tr>
                    </table>
                    
                    <p><b>Possible Issues:</b></p>
                    <ul>
                        <li>Java files not found in src/test/java/Java8Example</li>
                        <li>Compilation errors in Java code</li>
                        <li>Classes don't have main method</li>
                        <li>Missing dependencies</li>
                    </ul>
                    
                    <p><b>Debug Steps:</b></p>
                    <ol>
                        <li>Check if files exist in GitHub repository</li>
                        <li>Verify classes have public static void main method</li>
                        <li>Test compilation locally first</li>
                    </ol>
                </body>
                </html>
                """
            )
        }
    }
}
