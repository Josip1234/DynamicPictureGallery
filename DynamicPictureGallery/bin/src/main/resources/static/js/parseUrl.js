function parse(){
    var collections=document.getElementsByClassName("txt");
    for(var i=0;i<collections.length;i++){
        //http://localhost:8080/DynamicPictureGallery/images/jbosnjak3@gmail.com/jbosnjak3@gmail.com/zenske-svecane-cipele-slika-180208020.jpg 
        var url=collections[i].src;
        var newUrl=url.replace("http://localhost:8080/DynamicPictureGallery/","http://localhost/DynamicPictureGallery/DynamicPictureGallery/");
        collections[i].src=newUrl;
    }
}
