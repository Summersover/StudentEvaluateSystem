import request from '@/utils/request'

export function getStuList() {
    return request({
        url: '/judge/getStuList',
        method: 'get',
    })
}

export function uploadStudentInfo(file) {
    const formData = new FormData()
    formData.append('file', file)

    return request({
        url: '/studentInfo/upload',
        method: 'post',
        headers: {
            'Content-Type': 'multipart/form-data',
        },
        data: formData,
    })
}

export function getStudentInfo() {
    return request({
        url: '/studentInfo/get',
        method: 'get',
    })
}




export function uploadStudentGPA(file) {
    const formData = new FormData()
    formData.append('file', file)

    return request({
        url: '/studentGPA/upload',
        method: 'post',
        headers: {
            'Content-Type': 'multipart/form-data',
        },
        data: formData,
    })
}


export function uploadStudentVolSer(file) {
    const formData = new FormData()
    formData.append('file', file)

    return request({
        url: '/studentVolSer/upload',
        method: 'post',
        headers: {
            'Content-Type': 'multipart/form-data',
        },
        data: formData,
    })
}

export function getStudentVolSerData() {
    return request({
        url: '/studentVolSer/getStudentVolSerData',
        method: 'get',
    })
}

export function getStudentGPAData() {
    return request({
        url: '/studentGPA/getStudentGPAData',
        method: 'get',
    })
}


//不同功能的评委api分开文件写了，本api只用于评测列表页获取学生列表

// export function sendStuNum(username) {
//     const data={
//         username,
//     }
//     return request({
//         url: '/judge/sendStuNum',
//         method: 'post',
//         data: data
//     })
// }
//
// export function getResSitu() {
//     return request({
//         url: '/judge/getResSitu',
//         method: 'get',
//     })
// }