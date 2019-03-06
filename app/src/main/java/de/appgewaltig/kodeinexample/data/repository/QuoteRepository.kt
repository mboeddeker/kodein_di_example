package de.appgewaltig.kodeinexample.data.repository

import androidx.lifecycle.LiveData
import de.appgewaltig.kodeinexample.data.model.Quote

interface QuoteRepository {
    fun addQuote(quote: Quote)
    fun getQuotes(): LiveData<List<Quote>>
}