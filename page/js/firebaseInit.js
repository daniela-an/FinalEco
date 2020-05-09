// Your web app's Firebase configuration
var firebaseConfig = {
    apiKey: "AIzaSyDv-vaeaBdjlXk5WXTK_EMHXwIYtvE3EAU",
    authDomain: "finaleco-d82e9.firebaseapp.com",
    databaseURL: "https://finaleco-d82e9.firebaseio.com",
    projectId: "finaleco-d82e9",
    storageBucket: "finaleco-d82e9.appspot.com",
    messagingSenderId: "76139057452",
    appId: "1:76139057452:web:aa16feb2c24281af6c1c89"
};

// Initialize Firebase
firebase.initializeApp(firebaseConfig);

    
var database = firebase.database();

const writeUserData = (id, obj, callback) => {
    firebase.database().ref('juegos/' + id).set(obj).then(e => callback());
}