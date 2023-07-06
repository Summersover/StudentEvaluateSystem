import request from '@/utils/request'

// 学生提交学生骨干岗位服务
export function updateWorServ(tableData, username) {
    const data={
        tableData,
        username,
    }
    return request({
        url: '/student/updateWorServ',
        method: 'post',
        data: data
    })
}

//学生查看已提交信息
export function getWorServ() {
    return request({
        url: '/student/getWorServ',
        method: 'get',
    })
}

// 学生删除已提交的学生骨干岗位服务
export function deleteWorServ(tableData, username) {
    const data={
        tableData,
        username,
    }
    return request({
        url: '/student/deleteWorServ',
        method: 'post',
        data: data
    })
}