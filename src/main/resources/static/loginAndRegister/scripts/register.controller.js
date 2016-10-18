
if (!loginAndRegister)
    var loginAndRegister = {};

if (!loginAndRegister.register)
    loginAndRegister.register = {};

loginAndRegister.register.RegisterController = function (registerService) {
    this.addUser = function() {
        this.loading = true;
        registerService.addUser(this.username,this.firstname,this.lastname,this.email,this.password1);
        this.loading = false;
    }

    this.username;
    this.firstname;
    this.lastname;
    this.email;
    this.password1;
    this.password2;
    this.loading = false;
}