package de.appgewaltig.kodeinexample.data.repository

import androidx.lifecycle.LiveData
import de.appgewaltig.kodeinexample.data.db.QuoteDao
import de.appgewaltig.kodeinexample.data.model.Quote

class QuoteRepositoryImpl(private val quoteDao: QuoteDao) : QuoteRepository {

    override fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    override fun getQuotes(): LiveData<List<Quote>> {
        return quoteDao.getQuotes()
    }
}