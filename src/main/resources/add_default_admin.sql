-----------------------
-- Insert default admin
-----------------------
INSERT INTO `users` (`id`, `first_name`, `last_name`, `password`, `email`) VALUES (1, 'alex', 'alex', 'alex', 'alex' /*Password1!*/);

-----------------------
-- Insert user_role
-----------------------
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES (1, 2);