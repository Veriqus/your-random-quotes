package com.selfformat.yourrandomquote

import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.quotes
import com.google.firebase.database.users
import com.google.firebase.database.withID
import com.selfformat.yourrandomquote.domain.DatabaseQuote

class QuoteDetailsViewModel(private val database: DatabaseReference) : ViewModel() {

    constructor() : this(
        FirebaseDatabase.getInstance().reference
    )

    fun addQuote(uid: String, databaseQuote: DatabaseQuote) {
        database.users().withID(uid).quotes().push().setValue(databaseQuote)
    }

    fun updateQuote(uid: String, quoteId: String, databaseQuote: DatabaseQuote) {
        database.users().withID(uid).quotes().withID(quoteId).setValue(databaseQuote)
    }

    fun removeQuote(uid: String, quoteId: String) {
        database.users().withID(uid).quotes().withID(quoteId).removeValue()
    }
}
