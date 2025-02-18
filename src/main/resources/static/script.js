var tries = 0;
var d_init = new Date();
var visited = d_init.getTime();
var is_hacked = false;
var time = 0;

console.log("test2");

function update_tries(){
	document.getElementById('tries').textContent = tries;
}

setInterval(myTimer, 1000);

function myTimer() {
  if(is_hacked){
	return;
  }
  const d = new Date();
  time = ((d.getTime()-visited)/1000)|0;
  document.getElementById("timer").innerHTML = String(time)+"s";
}
function hacked(){
	d = new Date();
	document.getElementById('victory').textContent = ' with '+tries+' tries in '+((d.getTime()-visited)/1000)+' secounds'
	document.getElementById('history').innerHTML =
		'<h1 class="mb-4 text-4xl font-extrabold leading-none tracking-tight text-gray-900 md:text-5xl lg:text-6xl dark:text-white  animate-ping"> Hacked</h1>';
	is_hacked = true;
	send_score();
	get_scores();

}
var data_copy = [];
function send_score(){
	var req = "http://localhost:8080/score?tries="+String(tries)+"&time="+String(time);
	console.log(req);
	fetch(req);
}
function get_scores(){
	fetch("http://localhost:8080/get_scores")
		.then(function(response) {
		  return response.json();
		}).then(function(data) {
		console.log(data);
		console.log(data.lenght);
		data_copy = data;
		var scoreboard = document.getElementById('scoreboard');
		var data_array = [];
		data.forEach(e => {
			
			//document.getElementById('history').innerHTML += 
			//"<p> tries:"+e["tries"]+" time:"+e["time"]+"sec </p>";
			console.log(e);
			data_array.push([e["tries"],e["time"]]);
			console.log("{scoreId:"+e["scoreID"]);
			console.log(" tries:"+e["tries"]);
			console.log("times:"+e["time"]+"}\n");
			
		});
		data_array.sort();
		console.log(data_array);
		scoreboard.innerHTML = "<tr><th><p> Rank:</th></p><th><p>tries</th></p><th><p>time</th></p></tr>";

		data_array.forEach(function(e,i){
			scoreboard.innerHTML += "<tr><th><p> "+String(i)+
				"</th></p><th><p>"+String(e[0])
				+"</th></p><th><p>"+String(e[1])+"</th></p></tr>";
		});
		}).catch(function(err) {
		  output.textContent = "backend error";
		  console.log('Fetch Error :-S', err);
		});

}

function send(){
	if(is_hacked){
		return;
	}

	var output = document.getElementById('output');
	var history = document.getElementById('history');
	var number = parseFloat(document.getElementById('textbox').value);
	if(isNaN(number)){
		output.textContent = "Syntax error: please enter a float"	
		return;
	}
	var answer = "not availble";

	fetch("http://localhost:8080/greeting?number="+number)
		.then(function(response) {
		  return response.json();
		}).then(function(data) {
		console.log(data);
		value = data["value"];
		
		tries += 1;
		update_tries();
		if(value == "Hacked"){
			hacked();
			return;
		}
		document.getElementById('history').innerHTML 
			= '<p>'+output.textContent+'</p>' + document.getElementById('history').innerHTML;
		  output.textContent = number + " -> "+value;
		}).catch(function(err) {
		  output.textContent = "backend error";
		  console.log('Fetch Error :-S', err);
		});


}

