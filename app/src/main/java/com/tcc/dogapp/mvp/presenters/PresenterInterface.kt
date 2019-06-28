package com.tcc.dogapp.mvp.presenters

interface MainPresenterListener {


    fun onIssueSelected(
        activity: ActivityBaseInterface,
        issue: Issue
    )

    fun requestIssueList(activity: ActivityBaseInterface)

}
