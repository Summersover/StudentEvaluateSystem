import request from '@/utils/request'

// 学生提交社会实践
export function updateSocPrac(tableData, username) {
    const data={
        tableData,
        username,
    }
    return request({
        url: '/student/updateSocPrac',
        method: 'post',
        data: data
    })
}

//学生查看已提交信息
export function getSocPrac() {
    return request({
        url: '/student/getSocPrac',
        method: 'get',
    })
}

// 学生删除已提交的社会实践
export function deleteSocPrac(tableData, username) {
    const data = {
        tableData,
        username,
    }
    return request({
        url: '/student/deleteSocPrac',
        method: 'post',
        data: data
    })
}