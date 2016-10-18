if (!loginAndRegister)
    var loginAndRegister = {};

if (!loginAndRegister.register)
    loginAndRegister.register = {};

loginAndRegister.register.RegisterService = function ($http) {
    this.addUser = function (username, firstname, lastname, email, password) {
        this.user = {
            username: username,
            firstname: firstname,
            lastname: lastname,
            email: email,
            password: password
        }
        console.log(this.user)
        $http.post("/adduser",this.user)
    }

}