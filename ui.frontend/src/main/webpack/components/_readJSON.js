(function (document){
    let listContent = ''; 
    const ul = document.getElementById("posts");
    fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response => response.json())
            .then(posts => {
                posts.forEach((element) => 
                    listContent += "<li>" + element.title + "</li>"
                );
                    
                   
                
                ul.innerHTML = listContent;
            });
        }
)(document);
