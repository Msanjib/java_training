function emailverify(email)
	{
	var filter=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
	str=email;
	if(!filter.test(str))
		{
		return false;
		}
	else return true;
	}


function validate()
	{
		var fname = document.getElementById('fname');
		var lname = document.getElementById('lname');
		var errorDisplay = document.getElementById('formCheck');
		
		if(fname.value==''){
			//alert('Enter your name');
			fname.focus();
			
			errorDisplay.innerHTML = "first name is empty";
			//Your Name :
			return false;
			
		}else if(lname.value==''){
			lname.focus();
			
			errorDisplay.innerHTML = "last name is empty";
			//Your Name :
			return false;
		}else{
			errorDisplay.innerHTML = "";
			return true;
		}
		
	}
function validateEdit()
{
	var fname = document.getElementById('edited-fname');
	var lname = document.getElementById('edited-lname');
	var errorDisplay = document.getElementById('edited-formCheck');
	
	if(fname.value==''){
		//alert('Enter your name');
		fname.focus();
		
		errorDisplay.innerHTML = "first name is empty";
		//Your Name :
		return false;
		
	}else if(lname.value==''){
		lname.focus();
		
		errorDisplay.innerHTML = "last name is empty";
		//Your Name :
		return false;
	}else{
		errorDisplay.innerHTML = "";
		return true;
	}
	
}

function validateDepartment(){
	var dname = document.getElementById('dname');
	var errorDisplay = document.getElementById('formCheckDep');
	
	if(dname.value==''){
		//alert('Enter your name');
		dname.focus();
		
		errorDisplay.innerHTML = "department name is empty";
		//Your Name :
		return false;
		
	}else{
		errorDisplay.innerHTML = "";
		return true;
	}
}

function validateEditDepartment()
{
	var dname = document.getElementById('edited-dname');
	var errorDisplay = document.getElementById('edited-formCheckDep');
	
	if(dname.value==''){
		//alert('Enter your name');
		dname.focus();
		
		errorDisplay.innerHTML = "department name is empty";
		//Your Name :
		return false;
		
	}else{
		errorDisplay.innerHTML = "";
		return true;
	}
	
}