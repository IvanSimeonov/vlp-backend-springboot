package bg.tusofia.vlp.user.controller;

import bg.tusofia.vlp.user.dto.UserCreateDto;
import bg.tusofia.vlp.user.dto.UserOverviewDto;
import bg.tusofia.vlp.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Class: UserController
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserOverviewDto> getUserOverviewById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getUserOverviewById(id));
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<UserOverviewDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody @Valid UserCreateDto userCreateDto) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(userService.createUser(userCreateDto))
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @Operation(
            summary = "Request Teacher Access",
            description = "Allows a student to request teacher access. The request is marked as pending and awaits admin approval.",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Teacher access request submitted successfully"
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden - Only users with the 'STUDENT' role can access this endpoint"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request - If the request could not be processed"
                    )
            }
    )
    @PutMapping()
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public ResponseEntity<Void> requestTeacherAccess() {
        this.userService.requestTeacherAccess();
        return ResponseEntity.noContent().build();
    }

}
