package de.appgewaltig.kodeinexample.data.db

class DatabaseFakeImpl: Database {
    override val quoteDao: QuoteDao = QuoteDaoFakeImpl()
}