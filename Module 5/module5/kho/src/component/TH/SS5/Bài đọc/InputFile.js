import React, { useState } from "react";

function FileUploadPage() {
    const [selectedFile, setSelectedFile] = useState();
    const [isFilePicked, setIsFilePicked] = useState(false);

    const changeHandler = event => {
        setSelectedFile(event.target.files[0]);
        setIsFilePicked(true);
    };

    const handleSubmission = () => {};
    return (
        <div>
            <input type="file" name="file" onChange={changeHandler} />
            {isFilePicked ? (
                <div>
                    <p>Filename: <span style={{color:"red"}}>{selectedFile.name}</span></p>
                    <p>Filetype: <span style={{color:"red"}}>{selectedFile.type}</span></p>
                    <p>Size in bytes: <span style={{color:"red"}}>{selectedFile.size}</span></p>
                    <p>
                        lastModifiedDate:{" "}
                        {selectedFile.lastModifiedDate.toLocaleDateString()}
                    </p>
                </div>
            ) : (
                <p>Select a file to show details</p>
            )}
            <div>
                <button onClick={handleSubmission}>Submit</button>
            </div>
        </div>
    );
}

export default FileUploadPage;