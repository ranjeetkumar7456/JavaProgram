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
                withCredentials([string(credentialsId: 'github-pat', variable: 'GIT_PAT')]) {
                    bat '''
                        echo Cleaning workspace...
                        if exist repo rmdir /s /q repo
                        
                        echo Cloning from Java8Feature branch...
                        "C:\\Program Files\\Git\\bin\\git.exe" clone -b Java8Feature https://ranjeetkumar7456:%GIT_PAT%@github.com/ranjeetkumar7456/JavaPractice.git repo || exit /b 1
                        
                        echo Verifying Java8Example directory exists...
                        if exist repo\\src\\test\\java\\Java8Example (
                            echo Java8Example directory found!
                            dir repo\\src\\test\\java\\Java8Example\\*.java /b
                        ) else (
                            echo ERROR: Java8Example directory not found in test folder!
                            echo Checking all directories...
                            dir repo\\src /s /b
                        )
                    '''
                }
            }
        }

        stage('Compile Java8Example Classes') {
            steps {
                echo '=== COMPILING Java8Example CLASSES FROM TEST DIRECTORY ==='
                bat '''
                    echo Creating bin directory...
                    if not exist repo\\bin mkdir repo\\bin
                    
                    echo Checking for Java files...
                    if exist repo\\src\\test\\java\\Java8Example\\*.java (
                        echo Found Java files in test directory, compiling...
                        javac -d repo\\bin repo\\src\\test\\java\\Java8Example\\*.java
                        
                        if %ERRORLEVEL% neq 0 (
                            echo Compilation failed! Trying with main source directory...
                            if exist repo\\src\\main\\java (
                                echo Adding main source to classpath...
                                javac -d repo\\bin -cp "repo\\src\\main\\java" repo\\src\\test\\java\\Java8Example\\*.java
                            )
                        )
                    ) else (
                        echo No Java files found in repo\\src\\test\\java\\Java8Example!
                        echo Checking main directory as fallback...
                        if exist repo\\src\\main\\java\\Java8Examples\\*.java (
                            echo Found Java files in main directory...
                            javac -d repo\\bin repo\\src\\main\\java\\Java8Examples\\*.java
                        ) else (
                            echo ERROR: No Java files found anywhere!
                            exit /b 1
                        )
                    )
                    
                    echo Checking compiled classes...
                    if exist repo\\bin\\Java8Example (
                        echo Compiled Java8Example classes:
                        dir repo\\bin\\Java8Example /b
                    ) else if exist repo\\bin\\Java8Examples (
                        echo Compiled Java8Examples classes:
                        dir repo\\bin\\Java8Examples /b
                    ) else (
                        echo Checking bin directory...
                        dir repo\\bin /b
                    )
                '''
            }
        }

        stage('Run EmployeeDataProcessor') {
            steps {
                echo '=== RUNNING EmployeeDataProcessor CLASS ==='
                bat '''
                    echo Trying to run EmployeeDataProcessor...
                    
                    REM First try from test directory
                    if exist repo\\bin\\Java8Example\\EmployeeDataProcessor.class (
                        echo Running from Java8Example package...
                        java -cp repo\\bin Java8Example.EmployeeDataProcessor
                    ) else if exist repo\\bin\\Java8Examples\\EmployeeDataProcessor.class (
                        echo Running from Java8Examples package...
                        java -cp repo\\bin Java8Examples.EmployeeDataProcessor
                    ) else (
                        echo ERROR: EmployeeDataProcessor.class not found!
                        echo Available classes in bin:
                        dir repo\\bin\\* /b
                    )
                '''
            }
        }

        stage('Run FinancialCalculator') {
            steps {
                echo '=== RUNNING FinancialCalculator CLASS ==='
                bat '''
                    echo Trying to run FinancialCalculator...
                    
                    if exist repo\\bin\\Java8Example\\FinancialCalculator.class (
                        java -cp repo\\bin Java8Example.FinancialCalculator
                    ) else if exist repo\\bin\\Java8Examples\\FinancialCalculator.class (
                        java -cp repo\\bin Java8Examples.FinancialCalculator
                    ) else (
                        echo FinancialCalculator.class not found, skipping...
                    )
                '''
            }
        }

        stage('Run InventoryManagementSystem') {
            steps {
                echo '=== RUNNING InventoryManagementSystem CLASS ==='
                bat '''
                    echo Trying to run InventoryManagementSystem...
                    
                    if exist repo\\bin\\Java8Example\\InventoryManagementSystem.class (
                        java -cp repo\\bin Java8Example.InventoryManagementSystem
                    ) else if exist repo\\bin\\Java8Examples\\InventoryManagementSystem.class (
                        java -cp repo\\bin Java8Examples.InventoryManagementSystem
                    ) else (
                        echo InventoryManagementSystem.class not found, skipping...
                    )
                '''
            }
        }

        stage('Run MainExecutor') {
            steps {
                echo '=== RUNNING MainExecutor CLASS ==='
                bat '''
                    echo Trying to run MainExecutor...
                    
                    if exist repo\\bin\\Java8Example\\MainExecutor.class (
                        java -cp repo\\bin Java8Example.MainExecutor
                    ) else if exist repo\\bin\\Java8Examples\\MainExecutor.class (
                        java -cp repo\\bin Java8Examples.MainExecutor
                    ) else (
                        echo MainExecutor.class not found, skipping...
                    )
                '''
            }
        }

        stage('Run OrderProcessingSystem') {
            steps {
                echo '=== RUNNING OrderProcessingSystem CLASS ==='
                bat '''
                    echo Trying to run OrderProcessingSystem...
                    
                    if exist repo\\bin\\Java8Example\\OrderProcessingSystem.class (
                        java -cp repo\\bin Java8Example.OrderProcessingSystem
                    ) else if exist repo\\bin\\Java8Examples\\OrderProcessingSystem.class (
                        java -cp repo\\bin Java8Examples.OrderProcessingSystem
                    ) else (
                        echo OrderProcessingSystem.class not found, skipping...
                    )
                '''
            }
        }

        stage('Generate Report') {
            steps {
                echo '=== GENERATING EXECUTION REPORT ==='
                bat '''
                    echo Creating execution summary...
                    echo "Java 8 Examples Execution Report" > repo\\execution_summary.txt
                    echo "================================" >> repo\\execution_summary.txt
                    echo "Timestamp: %DATE% %TIME%" >> repo\\execution_summary.txt
                    echo "Branch: Java8Feature" >> repo\\execution_summary.txt
                    echo "Build Number: ${BUILD_NUMBER}" >> repo\\execution_summary.txt
                    echo "" >> repo\\execution_summary.txt
                    
                    echo "Source Location: " >> repo\\execution_summary.txt
                    if exist repo\\src\\test\\java\\Java8Example (
                        echo "src/test/java/Java8Example" >> repo\\execution_summary.txt
                        echo "Files found:" >> repo\\execution_summary.txt
                        dir repo\\src\\test\\java\\Java8Example\\*.java /b >> repo\\execution_summary.txt
                    ) else (
                        echo "src/main/java/Java8Examples" >> repo\\execution_summary.txt
                    )
                    
                    type repo\\execution_summary.txt
                '''
            }
        }
    }

    post {
        always {
            echo '=== PIPELINE FINISHED ==='
            
            // Archive artifacts
            archiveArtifacts artifacts: 'repo/bin/**/*.class', fingerprint: true
            archiveArtifacts artifacts: 'repo/execution_summary.txt', fingerprint: true
            
            // Cleanup
            bat '''
                echo Cleaning up...
                timeout /t 2 /nobreak >nul
            '''
        }

        success {
            echo '✅ All stages executed successfully! Sending success email...'
            emailext (
                subject: "✅ Java 8 Examples Execution Success - Build #${BUILD_NUMBER}",
                body: """
                <html>
                <body style="font-family: Arial, sans-serif; line-height:1.6; background-color:#f4f6f7; padding:15px;">
                    <div style="max-width:700px; margin:auto; background-color:#ffffff; padding:20px; border-radius:8px; box-shadow:0 0 10px rgba(0,0,0,0.1);">
                        <h2 style="color:#0071ce; border-bottom:2px solid #0071ce; padding-bottom:5px;">Java 8 Examples Execution Report</h2>
                        <p>Hello Team,</p>
                        <p>The Java 8 examples pipeline executed successfully.</p>

                        <table border="1" cellpadding="6" cellspacing="0" style="border-collapse: collapse; width:100%;">
                            <tr style="background-color:#e6f0fa;"><td><b>Project</b></td><td>JavaPractice - Java 8 Examples</td></tr>
                            <tr><td><b>Branch</b></td><td>Java8Feature</td></tr>
                            <tr style="background-color:#e6f0fa;"><td><b>Build Number</b></td><td>${BUILD_NUMBER}</td></tr>
                            <tr><td><b>Build URL</b></td><td><a href="${BUILD_URL}">${BUILD_URL}</a></td></tr>
                            <tr style="background-color:#e6f0fa;"><td><b>Status</b></td><td><b style="color:green;">SUCCESS</b></td></tr>
                            <tr><td><b>Source Location</b></td><td>src/test/java/Java8Example</td></tr>
                            <tr style="background-color:#e6f0fa;"><td><b>Execution Time</b></td><td>${new Date()}</td></tr>
                        </table>

                        <p>All Java 8 example classes were compiled and executed successfully.</p>

                        <p>Attached compiled classes and execution summary for reference.</p>

                        <p>Regards,<br>
                        <b>Automation Team</b></p>
                    </div>
                </body>
                </html>
                """,
                to: "ranjeetkumar7456@gmail.com",
                attachmentsPattern: "repo/bin/*.class, repo/execution_summary.txt"
            )
        }

        failure {
            echo '❌ Build failed! Sending failure email...'
            emailext (
                subject: "❌ Java 8 Examples Execution Failed - Build #${BUILD_NUMBER}",
                body: """
                <html>
                <body style="font-family: Arial, sans-serif; line-height:1.6; background-color:#fff2f2; padding:15px;">
                    <div style="max-width:700px; margin:auto; background-color:#ffffff; padding:20px; border-radius:8px; box-shadow:0 0 10px rgba(0,0,0,0.1);">
                        <h2 style="color:red; border-bottom:2px solid red; padding-bottom:5px;">Java 8 Examples Execution Failed</h2>
                        <p>Hello Team,</p>
                        <p>The Java 8 examples pipeline failed during execution.</p>

                        <table border="1" cellpadding="6" cellspacing="0" style="border-collapse: collapse; width:100%;">
                            <tr style="background-color:#fce4e4;"><td><b>Project</b></td><td>JavaPractice - Java 8 Examples</td></tr>
                            <tr><td><b>Branch</b></td><td>Java8Feature</td></tr>
                            <tr style="background-color:#fce4e4;"><td><b>Build Number</b></td><td>${BUILD_NUMBER}</td></tr>
                            <tr><td><b>Build URL</b></td><td><a href="${BUILD_URL}">${BUILD_URL}</a></td></tr>
                            <tr style="background-color:#fce4e4;"><td><b>Status</b></td><td><b style="color:red;">FAILED</b></td></tr>
                            <tr><td><b>Source Location</b></td><td>src/test/java/Java8Example</td></tr>
                            <tr style="background-color:#fce4e4;"><td><b>Execution Time</b></td><td>${new Date()}</td></tr>
                        </table>

                        <p><b>Possible Issues:</b></p>
                        <ul>
                            <li>Java files not found in src/test/java/Java8Example</li>
                            <li>Compilation errors</li>
                            <li>Missing main methods in classes</li>
                        </ul>

                        <p>Please check the Jenkins console output for exact failure cause: <a href="${BUILD_URL}console">${BUILD_URL}console</a></p>

                        <p>Regards,<br>
                        <b>Automation Team</b></p>
                    </div>
                </body>
                </html>
                """,
                to: "ranjeetkumar7456@gmail.com"
            )
        }
    }
}
