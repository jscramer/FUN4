module.exports = {
    devServer: {
        port: 8081,
        proxy: {
            "/good-names": {
                target: "http://localhost:8080",
                secure: false
            },
            "/add-name": {
                target: "http://localhost:8080",
                secure: false
            },
            "/delete-user": {
                target: "http://localhost:8080",
                secure: false
            }

        }
    }
};