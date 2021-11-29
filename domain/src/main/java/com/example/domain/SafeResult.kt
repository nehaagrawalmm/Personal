package com.example.domain

sealed class SafeResult {
    class Success() : SafeResult()
    class Failure() : SafeResult()
}