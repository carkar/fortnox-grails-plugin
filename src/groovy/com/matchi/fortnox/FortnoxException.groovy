package com.matchi.fortnox

import com.matchi.fortnox.domain.FortnoxError

class FortnoxException extends RuntimeException {
    FortnoxError error

    FortnoxException(FortnoxError error) {
        this.error = error
        this.message = "FortnoxError ${error.code}: ${error.message}"
    }

    FortnoxException(String s, FortnoxError error) {
        super(s)
        this.error = error
    }
}
