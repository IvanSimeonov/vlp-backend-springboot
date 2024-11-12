package bg.tusofia.vlp.user.service;

import bg.tusofia.vlp.exception.UserNotFoundException;
import bg.tusofia.vlp.user.domain.RoleType;
import bg.tusofia.vlp.user.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

/**
 * Interface: UserManagementService
 * <p>
 * This interface defines the contract for managing user accounts within the application.
 * It provides methods for retrieving user information, creating users, assigning roles,
 * enabling or disabling user accounts, and deleting users. All operations are restricted
 * to admin users only.
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public interface UserManagementService {

    /**
     * Retrieves a user by their unique identifier.
     *
     * @param id the unique identifier of the user to retrieve
     * @return a {@link UserOverviewDto} containing user details
     *         or null if no user is found with the specified id
     *         Note: This method can only be called by an admin user.
     */
    UserOverviewDto getUserById(Long id);

    /**
     * Retrieves a paginated list of users based on search criteria.
     *
     * @param criteria the criteria used to filter users
     * @param pageable pagination information including page number and size
     * @return a {@link Page} containing a list of {@link UserOverviewDto} objects
     *         that match the search criteria
     *         Note: This method can only be called by an admin user.
     */
    Page<UserOverviewDto> getAllUsers(UserSearchCriteriaDto criteria, Pageable pageable);

    /**
     * Creates a new admin user in the system.
     *
     * @param userCreateDto the data transfer object containing information about the new admin user
     * @return the unique identifier of the newly created admin user
     *         Note: This method can only be called by users having the ADMIN or ROOT_ADMIN role.
     */
    Long createAdminUser(UserCreateDto userCreateDto);

    /**
     * Changes the role of an existing user.
     *
     * @param userId the unique identifier of the user whose role will be changed
     * @param newRole the new role to assign to the user
     *         Note: This method can only be called by users having the ADMIN or ROOT_ADMIN role.
     */
    void changeUserRole(Long userId, RoleType newRole);

    /**
     * Assigns the admin role to an existing user.
     *
     * @param userId the unique identifier of the user to whom the admin role will be assigned
     *         Note: This method can only be called by users having the ADMIN or ROOT_ADMIN role.
     */
    void assignAdminRole(Long userId);

    /**
     * Assigns the teacher role to an existing user.
     *
     * @param userId the unique identifier of the user to whom the teacher role will be assigned
     *         Note: This method can only be called by users having the ADMIN or ROOT_ADMIN role.
     */
    void assignTeacherRole(Long userId);

    /**
     * Enables a user account, allowing them to log in and access services.
     *
     * @param userId the unique identifier of the user to enable
     *         Note: This method can only be called by users having the ADMIN or ROOT_ADMIN role.
     */
    void enableUser(Long userId);

    /**
     * Disables a user account, preventing them from logging in and accessing services.
     *
     * @param userId the unique identifier of the user to disable
     *         Note: This method can only be called by users having the ADMIN or ROOT_ADMIN role.
     */
    void disableUser(Long userId);

    /**
     * Changes the password for a specified user by securely updating it to a new password.
     * This method encodes the new password before storing it in the database.
     * Only the authenticated user can change their own password.
     *
     * @param userId the unique ID of the user whose password is being changed
     * @param userPasswordUpdateDto the dto containing the old and the new password to set for the user, which will be encoded before saving
     * @throws UserNotFoundException if no user exists with the specified {@code userId}
     */
    void changeUserPassword(Long userId, UserPasswordUpdateDto userPasswordUpdateDto);

    /**
     * Updates the profile info for a specified user by providing detailed info.
     *
     * @param userId the unique ID of the user whose profile image is being updated
     * @param userProfileUpdateDto the new info to be added and set as the user's profile info
     * @throws UserNotFoundException if no user exists with the specified {@code userId}
     */
    void changeUserProfile(Long userId, UserProfileUpdateDto userProfileUpdateDto);

    /**
     * Updates the profile image for a specified user by uploading a new image file.
     * This method stores the uploaded file, saves the image path in the user's profile,
     * and updates the user's profile with the new image information.
     *
     * @param userId the unique ID of the user whose profile image is being updated
     * @param avatar the new image file to be uploaded and set as the user's profile image
     * @throws UserNotFoundException if no user exists with the specified {@code userId}
     */
    void changeUserAvatar(long userId, MultipartFile avatar);

    /**
     * Deletes a user account from the system permanently.
     *
     * @param userId the unique identifier of the user to delete
     *         Note: This method can only be called by users having the ADMIN or ROOT_ADMIN role.
     */
    void deleteUser(Long userId);
}
