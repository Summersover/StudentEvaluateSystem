import request from "@/utils/request";


export function getStuInfo() {
    return request({
        url: '/stu/get',
        method: 'get',
    })
}


export function getGpa() {
    return request({
        url: '/studentGPA/getGPA',
        method: 'get',
    })
}

export function getVolSer() {
    return request({
        url: '/studentVolSer/getVolSer',
        method: 'get',
    })
}

export function uploadFile(file) {
    const formData = new FormData()
    formData.append('file', file)

    return request({
        url: '/file/upload',
        method: 'post',
        headers: {
            'Content-Type': 'multipart/form-data',
        },
        data: formData,
    })
}