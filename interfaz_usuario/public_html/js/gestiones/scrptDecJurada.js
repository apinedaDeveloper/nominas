gblMaskInput=false;
gblMaskInput2=false;

jQuery(function($){
    
    $.mask.definitions['h']='[0-2]';
    $.mask.definitions['m']='[0-5]';   
    
});
    
	
function createHorarioAction(){
gblMaskInput=false;
gblMaskInput2=false;
return false;
}
	
function setMask(vInput){      
if (gblMaskInput==false) 
{
	
     $(vInput).mask("h9:m9");
     gblMaskInput=true;
}
return false;
}

function setMask2(vInput){      
if (gblMaskInput2==false) 
{
	
     $(vInput).mask("h9:m9");
     gblMaskInput2=true;
}
return false;
}
