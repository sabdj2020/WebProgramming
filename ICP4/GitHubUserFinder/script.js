function getGithubInfo(user) {
    //1. Create an instance of XMLHttpRequest class and send a GET request using it.
    // The function should finally return the object(it now contains the response!)

//get the data from url github and parse to the Json file
    const xhr = new XMLHttpRequest();
    const url = `https://api.github.com/users/${user}`;
    var response;
    xhr.open('GET', url, true);
    // Send the request to the server
    xhr.send();
    xhr.onload = function() {

        // Parse data into JSON format
        if (xhr.status == 200)
        {
            const data = JSON.parse(this.response);
            // show in the console
            console.log(data);
            showUser(data);
        }
    }
}
function showUser(user) {
    //2. set the contents of the h2 and the two div elements in the div '#profile' with the user content
    var name   = user.name;
    var id   = user.id;
    var uname   = user.login;
    var avatar_url     = user.avatar_url;
    var url = user.html_url;
    var location   = user.location;
    var followers = user.followers;
    var following = user.following;
    var repos     = user.public_repos;

    // display info about th user

    var outhtml = '<div><a href="'+url+'" target="_blank"><img src="'+avatar_url+'" width="100" height="100" alt="'+username+' "></a></div>';
    outhtml = outhtml + '<h2>username: <a href="'+url+'" target="_blank">'+uname+'</a></h2>';
    outhtml = outhtml + '<div><p>full name: '+name+' </p></div>';
    outhtml = outhtml + '<div><p>Github ID: '+id+' </p></div>';
    outhtml = outhtml + '<div><p>Github URL: '+url+' </p></div>';
    outhtml = outhtml + '<div><p>location: '+location+' </p></div>';
    outhtml = outhtml + '<div><p>Followers: '+followers+' </p></div>';
    outhtml = outhtml + '<div><p>Following: '+following+' </p></div>';
    outhtml = outhtml + '<div><p>repositories: '+repos+' </p></div>';

    outhtml = outhtml + '<div class="repolist clearfix">';
// the info displayed to the div with id #info
    document.getElementById('texty').innerHTML = user.name;
    $('#info').html(outhtml);
    $("#button").text("Check Another User!");
}

function noSuchUser(username) {
    //3. set the elements such that a suitable message is displayed

}

$(document).ready(function () {
    $(document).on('keypress', '#username', function (e) {
        //check if the enter(i.e return) key is pressed
        if (e.which == 13) {
            //get what the user enters
            username = $(this).val();
            //reset the text typed in the input
            $(this).val("");
            //get the user's information and store the respsonse
            response = getGithubInfo(username);
            //if the response is successful show the user's details
            if (response.status == 200) {
                showUser(JSON.parse(response.responseText));
                //else display suitable message
            } else {
                noSuchUser(username);
            }
        }
    })
});
