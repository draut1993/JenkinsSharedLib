def call(String buildStatus, String email) {

    if (!buildStatus) {
        buildStatus = "UNKNOWN"
    }

    def subject = "Jenkins Build Status: ${buildStatus}"
    def body = """
Hello Team,

Job Name   : ${env.JOB_NAME}
Build No   : ${env.BUILD_NUMBER}
Status     : ${buildStatus}

Please review logs for more information.

Regards,
Jenkins
"""

    emailext(
        to: email,
        subject: subject,
        body: body,
        attachLog: true
    )
}

