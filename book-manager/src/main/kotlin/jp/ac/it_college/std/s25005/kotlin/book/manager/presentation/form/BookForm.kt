package jp.ac.it_college.std.s25005.kotlin.book.manager.presentation.form

import jp.ac.it_college.std.s25005.kotlin.book.manager.domain.model.BookWithRental
import jp.ac.it_college.std.s25005.kotlin.book.manager.domain.model.Rental
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

/**
 * 想定するJSON形式
 * {
 *   "book_list": [
 *     {"id":100,"title":"Kotlin入門","author":"コトリン太郎","release_date":"1970-10-01"},
 *     {"id":200,"title":"Java入門","author":"ジャヴァ太郎","release_date":"2006-10-01"},
 *   ]
 * }
 */
@Serializable
data class GetBookListResponse(
    val bookList: List<BookInfo>
)

/**
 * 想定するJSON形式
 * {
 *   "id": 100,
 *   "title": "Kotlin入門",
 *   "author": "コトリン太郎",
 *   "release_date": "1970-03-21"
 * }
 */
@Serializable
data class BookInfo(
    val id: Long,
    val title: String,
    val author: String,
    val isRental: Boolean,
) {
    constructor(model: BookWithRental) : this(
        id = model.book.id,
        title = model.book.title,
        author = model.book.author,
        isRental = model.isRental
    )
}

/**
 * 想定する JSON データフォーマット
 * {
 *   "id": 100, "title": "Kotlin入門", "author": "コトリン太郎",
 *   "release_date": "1950-10-01",
 *   "rental_info": { ... }
 * }
 */
@Serializable
data class GetBookDetailResponse(
    val id: Long,
    val title: String,
    val author: String,
    val releaseDate: LocalDate,
    val rentalInfo: RentalInfo?
) {
    constructor(model: BookWithRental) : this(
        id = model.book.id,
        title = model.book.title,
        author = model.book.author,
        releaseDate = model.book.releaseDate,
        rentalInfo = model.rental?.let(::RentalInfo)
    )
}

/**
 * 想定する JSON データフォーマット
 * {
 *   "user_id": 1,
 *   "rental_datetime": "2026-06-17 14:50:23",
 *   "return_deadline": "2026-06-24 14:50:23"
 * }
 */
@Serializable
data class RentalInfo(
    val userId: Long,
    val rentalDatetime: LocalDateTime,
    val returnDeadline: LocalDateTime,
) {
    constructor(model: Rental) : this(
        userId = model.userId,
        rentalDatetime = model.rentalDateTime,
        returnDeadline = model.returnDeadline,
    )
}

@Serializable
data class RegisterBookRequest(
    val id: Long,
    val title: String,
    val author: String,
    val releaseDate: LocalDate
)

@Serializable
data class UpdateBookRequest(
    val id: Long,
    val title: String?,
    val author: String?,
    val releaseDate: LocalDate?,
)