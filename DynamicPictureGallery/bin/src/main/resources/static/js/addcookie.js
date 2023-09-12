function storeValue(){
    var gallery_name=document.getElementById("gn").value;
//this will fix spacing between gallery name 
var gn=gallery_name.replaceAll(" ","_");
document.cookie = "gallery_name="+gn;
   
 return true;

}

function store_values(id){

    document.cookie = "gallery_name="+id;
    var preview='/galleryPreview';
    var host=window.location.href+preview;
    
    location.href=host;
}
function deleteCookies(){
    document.cookie = "gallery_name=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/DynamicPictureGallery;";
  }

  function addSelectTypeOfGalleryCookie(){
    var value = document.getElementById("gal_type").value;
    var cook="gallery_type="+value;
    document.cookie=cook;
  }
  function deleteCookieTypeOfGallery(){
    document.cookie = "gallery_type=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/DynamicPictureGallery;";
  }

  function removeScriptSlideShow(){
     var value=document.getElementById('slideshow');
     alert(value.outerHTML);
     value.innerHTML="";
  }