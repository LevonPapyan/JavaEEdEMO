import manager.UserManager;
import models.UserEntity;

public class Main {

    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        UserEntity user = UserEntity.builder()
                .email("maga@gmail.com")
                .lastName("murazyan")
                .firstName("Maga")
                .password("123789")
                .build();
        UserEntity savedUser = userManager.add(user);
        System.out.println("User saved with id ="+savedUser.getId());
    }
}
