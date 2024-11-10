package bg.tusofia.vlp.user.controller;

import bg.tusofia.vlp.user.dto.UserOverviewDto;
import bg.tusofia.vlp.user.dto.UserSearchCriteriaDto;
import bg.tusofia.vlp.user.service.UserManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class: AdminController
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@RestController
@RequestMapping("/api/v1/admin/users")
@RequiredArgsConstructor
public class AdminController {

    private final UserManagementService userManagementService;

    @GetMapping
    public Page<UserOverviewDto> getUsers(UserSearchCriteriaDto userSearchCriteriaDto, Pageable pageable) {
        return userManagementService.getAllUsers(userSearchCriteriaDto, pageable);
    }
}
