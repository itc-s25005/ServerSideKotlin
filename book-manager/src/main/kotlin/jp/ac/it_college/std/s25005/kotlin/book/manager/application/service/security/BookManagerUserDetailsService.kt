package jp.ac.it_college.std.s25005.kotlin.book.manager.application.service.security

import jp.ac.it_college.std.s25005.kotlin.book.manager.application.service.AuthenticationService
import jp.ac.it_college.std.s25005.kotlin.book.manager.domain.model.User
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper.UserDynamicSqlSupport.user
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

class BookManagerUserDetailsService(
    private val authenticationService: AuthenticationService
): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = authenticationService.findUser(username)
            ?: throw UsernameNotFoundException("$username に該当するユーザーはいません")
        return BookManagerUserDetails(user)
    }
}

data class BookManagerUserDetails(
    val user: User
) : UserDetails {
    override fun getAuthorities(): Collection<out GrantedAuthority> {
        return AuthorityUtils.createAuthorityList(
            user.roleType.name
        )
    }

    override fun getPassword(): String? {
        return user.password
    }

    override fun getUsername(): String {
        return user.name
    }
}