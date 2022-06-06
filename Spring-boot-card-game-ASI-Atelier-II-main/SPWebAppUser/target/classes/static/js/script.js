function newLocation(){
	window.location = "http://localhost:8083/index.html";
	console.log(location);
}
///////////////// INSCRIPTION

function loadIndex() {
    if(localStorage.getItem('userToken')) {
        document.getElementById("buy-card").removeAttribute("hidden");
        document.getElementById("sell-card").removeAttribute("hidden");
    }
}

function handleSubmit(){

	//newLocation();
	
    let form = document.getElementById("formUser");
    let data = new FormData(form);

    const value = Object.fromEntries(data.entries());
    console.log({value});
    sendUser(value);
}

function sendUser(data){

    const POST_URL="http://localhost:8083/users"; 
    let context =   {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json',
                            'Accept': 'application/json',
'Authorization': `Bearer ${localStorage.getItem('userToken')}`,
                        },
                        body: JSON.stringify(data),
                    };
    
	console.log(data);
	console.log("coucou c est la fonction inscription");
	
    fetch(POST_URL,context)
            .then(response => callback(response))
            .catch(error => err_callback(error));
}



function callback(response){
	if (!response.ok) {
		alert("Cet utilisateur existe déjà!");
		return err_callback(response);
	}
	newLocation();
    console.log(response.value);
}

function err_callback(error){
    console.log(error);
}

///////////////// CONNEXION 
function newLocationCnx(){
	window.location = "http://localhost:8083/index.html";
	console.log(location);
}

function connectSubmit(){
	
    let form = document.getElementById("connectForm");
    let data = new FormData(form);

    const value = Object.fromEntries(data.entries());
    console.log({value});
    checkUser(value);
}

function checkUser(data){

    const POST_URL="http://localhost:8083/login";
    let context =   {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json',
                            'Accept': 'application/json',
                        },
                        body: JSON.stringify(data),
                    };
    
	console.log(data);
	console.log("coucou c'est la fonciton connexion'");
	
    fetch(POST_URL,context)
            .then(response => callbackConnect(response))
            .catch(error => err_callback(error));
}

function callbackConnect(response){
	if (!response.ok) {
		alert("Erreur de connexion");
		return err_callback(response);
	}
    response.text().then(res =>{
        localStorage.setItem('userToken',res);
        newLocationCnx();
        console.log(response);
    })
}


