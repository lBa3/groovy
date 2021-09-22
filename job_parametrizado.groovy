job ('ejemplo_job_DSL_en_GIT'){
  description('job DSL de ejemplo para jenkisn')
  scm{
    git('https://github.com/lBa3/job1jenkins.git', 'main')
    {
      node ->
      node / gitConfigName('lBatres') 
      node / gitConfigEmail('lrbg_02@hotmail.com')
    }
  }
  parameters {
    stringParam('nombre', defaultValue = 'Julian', description = 'algo algo bla bla...')
    choiceParam('planeta', ['TIERRA', 'MERCURIO', 'PLUTON', 'JUPITER'])
    booleanParam('agente', false)
  }
  triggers{
    cron('H/7 * * * *')
  }
  steps{
    shell("bash jobjenkins1.sh")
  }
  publishers{
    mailer('lbatres@freelancerdevelopers.com', true, true)
    slackNotifier {
      notifyAborted(true)
      notifyEveryFailure(true)
      notifyNotBuilt(false)
      notifyUnstable(false)
      notifyBackToNormal(true)
      notifySuccess(false)
      notifyRepeatedFailure(false)
      startNotification(false)
      includeTestSummary(false)
      includeCustomMessage(false)
      customMessage(null)
      sendAs(null)
      commitInfoChoice('NONE')
      teamDomain(null)
      authToken(null)
    }
  }
}
