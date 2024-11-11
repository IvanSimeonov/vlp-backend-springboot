package bg.tusofia.vlp.user.controller;

import bg.tusofia.vlp.user.domain.RoleType;
import bg.tusofia.vlp.user.dto.UserCreateDto;
import bg.tusofia.vlp.user.dto.UserOverviewDto;
import bg.tusofia.vlp.user.dto.UserSearchCriteriaDto;
import bg.tusofia.vlp.user.service.UserManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    @GetMapping("/{userId}")
    public ResponseEntity<UserOverviewDto> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userManagementService.getUserById(userId));
    }

    @GetMapping
    public ResponseEntity<Page<UserOverviewDto>> getUsers(UserSearchCriteriaDto userSearchCriteriaDto, Pageable pageable) {
        return ResponseEntity.ok(userManagementService.getAllUsers(userSearchCriteriaDto, pageable));
    }

    @PostMapping
    public ResponseEntity<Void> createAdminUser(@RequestBody @Valid UserCreateDto userCreateDto) {
        var userId = userManagementService.createAdminUser(userCreateDto);
        return entityWithLocation(userId);
    }

    @PutMapping("/{userId}/change-role")
    public ResponseEntity<Void> changeUserRole(@PathVariable Long userId, @RequestParam RoleType newRole) {
        userManagementService.changeUserRole(userId, newRole);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userId}/assign-admin")
    public ResponseEntity<Void> assignAdminRole(@PathVariable Long userId) {
        userManagementService.assignAdminRole(userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userId}/assign-teacher")
    public ResponseEntity<Void> assignTeacherRole(@PathVariable Long userId) {
        userManagementService.assignTeacherRole(userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userId}/enable")
    public ResponseEntity<Void> enableUser(@PathVariable Long userId) {
        userManagementService.enableUser(userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userId}/disable")
    public ResponseEntity<Void> disableUser(@PathVariable Long userId) {
        userManagementService.disableUser(userId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userManagementService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    private ResponseEntity<Void> entityWithLocation(Object resourceId) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{resourceId}")
                .buildAndExpand(resourceId)
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
