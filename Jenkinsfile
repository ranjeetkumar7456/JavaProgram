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
                    '''
                }
            }
        }

        /*************** 2. COMPILE JAVA FILES ***************/
        stage('Compile All Classes') {
            steps {
                echo '=== COMPILING ALL CLASSES IN PROJECT ==='

                bat '''
                    if not exist repo\\bin mkdir repo\\bin

                    echo Compiling Java source...
                    javac -d repo\\bin repo\\src\\main\\java\\Java8Examples\\*.java

                    if %ERRORLEVEL% neq 0 (
                        echo Java compilation failed!
                        exit /b 1
                    )
                '''
            }
        }

        /*************** 3. RUN ALL JAVA MODULES ***************/
        stage('Run EmployeeDataProcessor') {
            steps {
                echo '=== RUNNING EmployeeDataProcessor CLASS ==='
                bat 'java -cp repo\\bin Java8Examples.EmployeeDataProcessor'
            }
        }

        stage('Run FinancialCalculator') {
            steps {
                echo '=== RUNNING FinancialCalculator CLASS ==='
                bat 'java -cp repo\\bin Java8Examples.FinancialCalculator'
            }
        }

        stage('Run InventoryManagementSystem') {
            steps {
                echo '=== RUNNING InventoryManagementSystem CLASS ==='
                bat 'java -cp repo\\bin Java8Examples.InventoryManagementSystem'
            }
        }

        stage('Run MainExecutor') {
            steps {
                echo '=== RUNNING MainExecutor CLASS ==='
                bat 'java -cp repo\\bin Java8Examples.MainExecutor'
            }
        }

        stage('Run OrderProcessingSystem') {
            steps {
                echo '=== RUNNING OrderProcessingSystem CLASS ==='
                bat 'java -cp repo\\bin Java8Examples.OrderProcessingSystem'
            }
        }

        /*************** 4. EXTENT REPORT PLACEHOLDER ***************/
        stage('Generate Extent Report') {
            steps {
                echo '=== GENERATING EXTENT REPORT (CUSTOM LOGIC CAN BE ADDED HERE) ==='
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
        }

        /*************** SUCCESS NOTIFICATION ***************/
        success {
            echo '✅ All stages executed successfully! Sending success email...'

            emailext (
                subject: "✅ Walmart Automation Test Execution Report - Build #${BUILD_NUMBER}",
                to: "ranjeetkumar7456@gmail.com, qa-team@walmart.com",
                attachmentsPattern: "repo/bin/*.class",
                body: """
                <html>
                <body style='font-family: Arial; background:#f4f6f7; padding:15px;'>
                    <h2 style='color:#0071ce;'>Walmart Automation Build Success</h2>
                    <p>The Jenkins pipeline executed successfully.</p>

                    <table border='1' cellpadding='6' style='border-collapse:collapse;'>
                        <tr><td><b>Project</b></td><td>Walmart Digital Platform</td></tr>
                        <tr><td><b>Branch</b></td><td>Java8Feature</td></tr>
                        <tr><td><b>Build Number</b></td><td>${BUILD_NUMBER}</td></tr>
                        <tr><td><b>Build URL</b></td><td><a href='${BUILD_URL}'>${BUILD_URL}</a></td></tr>
                        <tr><td><b>Status</b></td><td style='color:green;'><b>SUCCESS</b></td></tr>
                        <tr><td><b>Date/Time</b></td><td>${new Date()}</td></tr>
                    </table>
                </body>
                </html>
                """
            )
        }

        /*************** FAILURE NOTIFICATION ***************/
        failure {
            echo '❌ Build failed! Sending failure email...'

            emailext (
                subject: "❌ Walmart Automation Test Execution Failed - Build #${BUILD_NUMBER}",
                to: "ranjeetkumar7456@gmail.com, qa-team@walmart.com",
                attachmentsPattern: "repo/bin/*.class",
                body: """
                <html>
                <body style='font-family: Arial; background:#fff2f2; padding:15px;'>
                    <h2 style='color:red;'>Walmart Automation Build Failure</h2>
                    <p>The Jenkins build failed. Please check logs.</p>

                    <table border='1' cellpadding='6' style='border-collapse:collapse;'>
                        <tr><td><b>Project</b></td><td>Walmart Digital Platform</td></tr>
                        <tr><td><b>Branch</b></td><td>Java8Feature</td></tr>
                        <tr><td><b>Build Number</b></td><td>${BUILD_NUMBER}</td></tr>
                        <tr><td><b>Build URL</b></td><td><a href='${BUILD_URL}'>${BUILD_URL}</a></td></tr>
                        <tr><td><b>Status</b></td><td style='color:red;'><b>FAILED</b></td></tr>
                        <tr><td><b>Date/Time</b></td><td>${new Date()}</td></tr>
                    </table>
                </body>
                </html>
                """
            )
        }
    }
}
