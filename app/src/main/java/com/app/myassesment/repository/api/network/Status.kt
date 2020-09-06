package com.app.myassesment.repository.api.network

/**
 * Created by Avdhesh Kumar on 05,Sept,2020
 */

 /**
 * Status of a resource that is provided to the UI.
 */
enum class Status {
     SUCCESS,
     ERROR,
     LOADING;

     /**
      * Returns `true` if the [Status] as per the status else `false`.
      */

     fun isSuccessful() = this == SUCCESS
     fun isLoading() = this == LOADING
     fun isError() = this == ERROR
 }