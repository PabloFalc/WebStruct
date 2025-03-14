/* Callbacks */

const userLogin = (email, password, callback) => {
    setTimeout(() => {
        console.log("user logged sem promisse");
        callback({ email: email });
    }, 1500);
    console.log("afterSetTimeout sem promisse");
};

const user = userLogin("my-email", "my-password", (callback) => {
    console.log("sem promisse: " + callback.email);
});

/* Promisses  */

const loginUserPromisse = (email, password) => {
    return new Promise((resolve, reject) => {
        const error = false;

        if (error) {
            reject(new Error("erro no login"));
        }

        console.log("user logged");
        resolve({ email });
    });
};

loginUserPromisse("email.com", "11222323").then((user) => {
    console.log({ user });
});
