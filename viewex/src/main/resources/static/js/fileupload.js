const fileUpload = {
	/*
	* 파일 업로드 처리
	*/
	process(files) {
		try {
			if(!files || files.length == 0) {
				throw new Error("파일을 업로드 하세요!");
			}
			
			const formData = new FormData();
			
			for(const file of files) {
				formData.append("file", file);
			}
			
			let url = "../file/upload";
			
			// gid 처리
			const gidEl = document.getElementById("gid");
			if(gidEl && gidEl.value.trim() != "") {
				url += "?gid=" + gid;
			}
			
			// XMLHttpRequest
			const xhr = new XMLHttpRequest();
			xhr.open("POST", url);
			xhr.addEventListener("readystatechange", function() {
				if(xhr.status == 200 && xhr.readyState == XMLHttpRequest.DONE) {
					const result = JSON.parse(xhr.responseText);
					if(result.success) { // 성공
						fileUpload.appendFiles(result.data);
						
						const fileEl = document.getElementById("file");
						fileEl.value = ""; // 업로드 완료후 선택된 파일 해제 
						
					} else { // 실패
						alert(result.message);
					}
				}
			});
			xhr.send(formData);
			
		} catch (err) {
			alert(err.message);
		}
	},
	/*
	* 업로드 완료 후 파일 목록 추가
	*/
	appendFiles(files) {
		if(!files || files.length == 0) {
			return;
		}
		
		const tpl = document.getElementById("tpl").innerHTML;
		const uploadFilesEl = document.getElementById("uploaded_files");
		const domParser = new DOMParser();
		for(const file of files) {
			let html = tpl;
			html = html.replace(/#\[id\]/g, file.id)
							.replace(/#\[fileName\]/g, file.fileName);
			console.log(html);
			
			const dom = domParser.parseFromString(html, "text/html");
			const liEl = dom.querySelector("li");
			uploadFilesEl.appendChild(liEl);
			
			const removeEl = liEl.querySelector(".remove");
			removeEl.addEventListener("click", this.deleteFile);
		}
	},
	deleteFile(e) {
		// this -> e.currentTarget
		// console.log(this);
		const id = this.dataset.id;
		if(!id) {
			return;
		}               
		
		const url = "../file/delete/" + id;
		const xhr = new XMLHttpRequest();
		xhr.open("GET", url);
		xhr.addEventListener("readystatechange", function() {
			if(xhr.status == 200 && xhr.readyState == XMLHttpRequest.DONE) {
				console.log(xhr.responseText);
			}
		});
		xhr.send(null);   
	}
};

window.addEventListener("DOMContentLoaded", function() {
	const dropBoxEl = document.getElementById("drop_box");
	if(dropBoxEl) {
		dropBoxEl.addEventListener("dragover", function(e) {
			e.preventDefault();
		});
		
		dropBoxEl.addEventListener("drop", function(e) {
			e.preventDefault();
			const files = e.dataTransfer.files;
			fileUpload.process(files);
		});
	}
	
	const fileEl = document.getElementById("file");
	if(fileEl) {
		fileEl.addEventListener("change", function(e) {
			const files = e.target.files;
			fileUpload.process(files);
		});
	}
});