package bg.tusofia.vlp.user.controller;

import bg.tusofia.vlp.user.domain.RoleType;
import bg.tusofia.vlp.user.dto.*;
import bg.tusofia.vlp.user.service.UserManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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

    @Operation(
            summary = "Get User Analytics",
            description = "Returns a list of user analytics",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved user analytics",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = UserAnalyticsDto.class)
                                    )
                            )
                    )
            }
    )
    @GetMapping("/analytics")
    public ResponseEntity<List<UserAnalyticsDto>> getUserAnalytics() {
        return ResponseEntity.ok(userManagementService.getUserAnalytics());
    }

    @Operation(
            summary = "Get User Teacher Access Requests",
            description = "Returns a page of user teacher access requests with pagination and sorting options",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved user teacher access requests",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = UserTeacherAccessRequestDto.class)
                                    )
                            )
                    )
            }
    )
    @GetMapping("/teacher-access-requests")
    public ResponseEntity<Page<UserTeacherAccessRequestDto>> getPendingTeacherAccessRequests(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "firstName") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection) {
        PageRequest pageRequest = PageRequest.of(
                pageNumber,
                pageSize,
                sortDirection.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending()
        );
        return ResponseEntity.ok(userManagementService.getUserTeacherAccessRequests(pageRequest));
    }

    @PostMapping
    public ResponseEntity<Void> createAdminUser(@RequestBody @Valid UserCreateDto userCreateDto) {
        var userId = userManagementService.createAdminUser(userCreateDto);
        return entityWithLocation(userId);
    }

    @Operation(
            summary = "Approve Teacher Access Request",
            description = "Approves a pending teacher access request for a user",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Teacher access approved successfully")
            }
    )
    @PutMapping("/teacher-access-requests/approve")
    public ResponseEntity<Void> approveTeacherAccessRequest(@RequestBody UserTeacherAccessRequestDto requestDto) {
        userManagementService.approveTeacherAccess(requestDto.id());
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Deny Teacher Access Request",
            description = "Denies a pending teacher access request for a user",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Teacher access denied successfully")
            }
    )
    @PutMapping("/teacher-access-requests/deny")
    public ResponseEntity<Void> denyTeacherAccessRequest(@RequestBody UserTeacherAccessRequestDto requestDto) {
        userManagementService.denyTeacherAccess(requestDto.id());
        return ResponseEntity.ok().build();
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

    @PutMapping("/{userId}/profile")
    public ResponseEntity<Void> updateUserProfile(@PathVariable Long userId, @RequestBody UserProfileUpdateDto userProfileUpdateDto) {
        userManagementService.changeUserProfile(userId, userProfileUpdateDto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userId}/profile-image")
    public ResponseEntity<Void> updateUserAvatar(@PathVariable Long userId, @RequestParam("file") MultipartFile file) {
        userManagementService.changeUserAvatar(userId, file);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userId}/change-password")
    public ResponseEntity<Void> changePassword(@PathVariable Long userId, @RequestBody UserPasswordUpdateDto userPasswordUpdateDto) {
        userManagementService.changeUserPassword(userId, userPasswordUpdateDto);
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
