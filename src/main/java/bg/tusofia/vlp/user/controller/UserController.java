package bg.tusofia.vlp.user.controller;

import bg.tusofia.vlp.user.dto.TeacherOverviewDto;
import bg.tusofia.vlp.user.dto.UserCreateDto;
import bg.tusofia.vlp.user.dto.UserOverviewDto;
import bg.tusofia.vlp.user.dto.UserPublicProfileDto;
import bg.tusofia.vlp.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserOverviewDto> getUserOverviewById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getUserOverviewById(id));
    }

    @GetMapping(value = "/{userId}/profile", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserPublicProfileDto> getUserPublicProfile(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(userService.getUserPublicProfileById(userId));
    }


    /**
     * Retrieves a user's profile image file.
     *
     * @param filePath the relative path of the image file
     * @return the image file as a resource
     */
    @GetMapping("/profile-image")
    public ResponseEntity<Resource> getProfileImage(@RequestParam String filePath) {
        try {
            Path imagePath = Paths.get("").resolve(filePath).normalize();
            Resource resource = new UrlResource(imagePath.toUri());

            if (resource.exists() && resource.isReadable()) {
                String fileExtension = getFileExtension(filePath);
                MediaType mediaType = switch (fileExtension) {
                    case "png" -> MediaType.IMAGE_PNG;
                    case "gif" -> MediaType.IMAGE_GIF;
                    default -> MediaType.IMAGE_JPEG;
                };
                return ResponseEntity.ok()
                        .contentType(mediaType)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<UserOverviewDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Operation(
            summary = "Get Top Teachers By Student Count",
            description = "Returns the top 3 featured teachers with most enrolled students"
    )
    @GetMapping(value = "/featured", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TeacherOverviewDto>> getTopTeachersByStudentCount() {
        return ResponseEntity.ok(userService.getTopTeachersByStudentCount());
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

    private String getFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex > 0) {
            return fileName.substring(lastDotIndex + 1);
        }
        return "";
    }

}
