package jp.ac.it_college.std.s25005.kotlin.book.manager.application.service

import jp.ac.it_college.std.s25005.kotlin.book.manager.domain.model.BookWithRental
import jp.ac.it_college.std.s25005.kotlin.book.manager.domain.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepository: BookRepository
) {
    fun getList(): List<BookWithRental> {
        return bookRepository.findAllWithRental()
    }

    fun getDetail(bookId: Long): BookWithRental {
        return bookRepository.findWithRental(bookId)
            ?: throw IllegalArgumentException("存在しない書籍ID: $bookId")
    }
}
