import request from '@/utils/request'

// 用户登录
export function login(username, password, captchaText) {
    const data = {
        username,
        password,
        captchaText
    }
    return request({
        url: '/auth/login',
        method: 'post',
        data: data
    })
}

// 获取用户信息
export function getInfo() {
    return request({
        url: '/user/profile/get',
        method: 'get'
    })
}

//获取验证码图片
export function captcha() {
    return request({
        url: '/auth/captcha',
        method:'get'
    })
}

//
// // 学生上传信息：个人学年总结
// export function updateSPSinfo(username, date, spot, level, role, eventname, behaviour, study, health) {
//     const data={
//         username,
//         date,
//         spot,
//         level,
//         role,
//         eventname,
//         behaviour,
//         study,
//         health
//     }
//     return request({
//         url: '/user/profile/updateSPSinfo',//url名字要变
//         method: 'post'
//     })
// }
//
// // 评委上传评分：个人年度总结
// export function updateJPSinfo(username,psmark) {
//     const data={
//         username,
//         psmark
//     }
//     return request({
//         url: '/user/profile/updateJPSinfo',//url名字要变
//         method: 'post'
//     })
// }
//
// // 获取信息：个人年度总结
// export function getPSInfo() {
//     return request({
//         url: '/user/profile/getPSinfo',//url名字要变
//         method: 'get'
//     })
// }
//
// // 学生上传信息：社会实践
// export function updateSSPinfo(username,initiator, spot, days, size, job, online, award, awardname,) {
//     const data={
//         username,
//         initiator,
//         spot,
//         days,
//         size,
//         job,
//         online,
//         award,
//         awardname,
//     }
//     return request({
//         url: '/user/profile/updateSSPinfo',//url名字要变
//         method: 'post'
//     })
// }
//
// // 评委上传评分：社会实践
// export function updateJSPinfo(username,spmark) {
//     const data={
//         username,
//         spmark
//     }
//     return request({
//         url: '/user/profile/updateJSPinfo',//url名字要变
//         method: 'post'
//     })
// }
//
// // 获取信息：社会实践
// export function getSPInfo() {
//     return request({
//         url: '/user/profile/getSPinfo',//url名字要变
//         method: 'get'
//     })
// }
//
//
// // 获取学生服务信息
// export function getWSInfo() {
//     return request({
//         url: '/user/profile/getWSinfo',//url名字要变
//         method: 'get'
//     })
// }
//
// // 上传学生服务评分信息
// export function updateJWSinfo(username,wsmark) {
//     const data={
//         username,
//         wsmark
//     }
//     return request({
//         url: '/user/profile/updateJWSinfo',//url名字要变
//         method: 'post'
//     })
// }
//
// // 学生上传学生服务信息
// export function updateSWSinfo(username,date,workname,job,level) {
//     const data={
//         username,
//         date,
//         workname,
//         job,
//         level
//     }
//     return request({
//         url: '/user/profile/updateSWSinfo',//url名字要变
//         method: 'post'
//     })
// }
//
// // 获取科研情况信息
// export function getRSInfo() {
//     return request({
//         url: '/user/profile/getRSinfo',//url名字要变
//         method: 'get'
//     })
// }
//
// // 上传学生科研情况信息
// export function updateJRSinfo(username,rsmark) {
//     const data={
//         username,
//         rsmark
//     }
//     return request({
//         url: '/user/profile/updateJRSinfo',//url名字要变
//         method: 'post'
//     })
// }
//
// // 学生上传科研情况信息
// export function updateSRSinfo(username,rank,time,place,prize) {
//     const data={
//         username,
//         rank,
//         time,
//         place,
//         prize
//     }
//     return request({
//         url: '/user/profile/updateSRSinfo',//url名字要变
//         method: 'post'
//     })
// }
//
// // 修改用户信息

