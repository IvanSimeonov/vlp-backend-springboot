package bg.tusofia.vlp.user.controller;

import bg.tusofia.vlp.user.dto.*;
import bg.tusofia.vlp.user.service.UserManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
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
@RequestMapping(value = "/api/v1/admin/users", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AdminController {

    private final UserManagementService userManagementService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserOverviewDto> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userManagementService.getUserById(userId));
    }

    @GetMapping
    public ResponseEntity<Page<UserOverviewDto>> getUsers(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "title") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection,
            UserSearchCriteriaDto userSearchCriteriaDto) {
        PageRequest pageRequest = PageRequest.of(
                pageNumber,
                pageSize,
                sortDirection.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending()
        );
        return ResponseEntity.ok(userManagementService.getAllUsers(userSearchCriteriaDto, pageRequest));
    }

    @GetMapping("/analytics")
    public ResponseEntity<List<UserAnalyticsDto>> getUserAnalytics() {
        return ResponseEntity.ok(userManagementService.getUserAnalytics());
    }

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

    @PutMapping("/{userId}/access-update")
    public ResponseEntity<Void> updateUserAccess(@PathVariable Long userId, @RequestBody UserAccessUpdateDto userAccessUpdateDto) {
        this.userManagementService.updateUserAccess(userId, userAccessUpdateDto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userId}/profile")
    public ResponseEntity<Void> updateUserProfile(@PathVariable Long userId, @RequestBody UserProfileUpdateDto userProfileUpdateDto) {
        userManagementService.changeUserProfile(userId, userProfileUpdateDto);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Upload profile image",
            description = "Allows users to upload or update their profile image"
    )
    @PutMapping(value = "/{userId}/profile-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> updateUserAvatar(@PathVariable Long userId, @RequestPart("file") MultipartFile file) {
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
