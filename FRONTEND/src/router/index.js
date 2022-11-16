import store from '@/store'
import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/crearForo',
    name: 'CrearForo',
    component: () => import('../views/CrearForo.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/Login.vue')
  },
  {
    path: '/login2',
    name: 'Login2',
    component: () => import('../views/LoginGab.vue')
  },
  {
    path: '/user/recuperaPswrd',
    name: 'recuperarPassword',
    component: () => import('../views/recuperaPswrd.vue')
  },
  {
    path: '/user/reset/:token',
    name: 'restabelecer',
    component: () => import('@/components/Reset.vue')
  },
  {
    path: '/ayuda',
    name: 'ayuda',
    component: () => import('../views/ayuda.vue'),
    meta: {requiresAuth: true}
  },
  {
    path: '/ayudaAdmin',
    name: 'ayudaAdmin',
    component: () => import('../views/admin/ayudaA.vue'),
    meta: {requiresAuth: true}
  },
  {
    path: '/ayudaCoord',
    name: 'ayudaCoord',
    component: () => import('../views/coordinador/ayudaC.vue'),
    meta: {requiresAuth: true}
  },
  {
    path: '/ayudaDocente',
    name: 'ayudaDocente',
    component: () => import('../views/docente/ayudaD.vue'),
    meta: {requiresAuth: true}
  },
  {
    path: '/ayudaEmpren',
    name: 'ayudaEmpren',
    component: () => import('../views/emprendimiento/ayudaE.vue'),
    meta: {requiresAuth: true}
  },
  {
    path: '/ayudaOrgSoc',
    name: 'ayudaOrgSoc',
    component: () => import('../views/orgSocial/ayudaOS.vue'),
    meta: {requiresAuth: true}
  },
  {
    path: '/ayudaPreins',
    name: 'ayudaPreins',
    component: () => import('../views/estudiante/ayudaP.vue'),
    meta: {requiresAuth: true}
  },
  {
    path: '/ayudaStud',
    name: 'ayudaStud',
    component: () => import('../views/estudiante/ayudaS.vue'),
    meta: {requiresAuth: true}
  },
  {
    path: '/respDG',
    name: 'respDG',
    component: () => import('../views/estudiante/respDG.vue'),
    meta: {requiresAuth: true}
  },
  {
    path: '/progress',
    name: 'progress',
    component: () => import('../views/estudiante/Progreso.vue'),
    meta: {requiresAuth: true}
  },
  {
    path: '/benchInd',
    name: 'benchInd',
    component: () => import('../views/estudiante/benchIndicadores.vue'),
    meta: {requiresAuth: true}
  },              
  {
    path: '/dgvfOs',
    name: 'dgvfOs',
    component: () => import('../views/orgSocial/forDGVOS.vue'),
    meta: {requiresAuth: true}
  },
  {
    path: '/foro',
    name: 'foro',
    component: () => import('../views/foro.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: '/noticias',
    name: 'noticias',
    component: () => import('../views/noticias.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: '/tejidoOS',
    name: 'tejidoOS',
    component: () => import('../views/orgSocial/tejidoOS.vue')
 //   ,meta: {requiresAuth: true}
  },
  {
    path: '/tejidoEmp',
    name: 'tejidoEmp',
    component: () => import('../views/emprendimiento/tejidoEm.vue')
  },  //ORGANIZACION SOCIAL
  {
    path: '/orgSocHome',
    name: 'orgSocHome',
    component: () => import('../views/orgSocial/HomeOrgSocial.vue')
    ,meta: {requiresAuth: true}
  },
  //ESTUDIANTE
  {
    path: '/studentHome',
    name: 'studentHome',
    component: () => import('../views/estudiante/HomeEstudiante.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: '/preinscHome',
    name: 'preinscHome',
    component: () => import('../views/estudiante/HomePreinscrito.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: '/encuesta',
    name: 'encuesta',
    component: () => import('../views/estudiante/Encuesta.vue')
  },

  //COORDINADOR
  {
    path: "/CoordHome",
    name: "CoordHome",
    component: () => import('../views/coordinador/Homecoordinador.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: "/ayudaCord",
    name: "ayudaCord",
    component: () => import('../views/coordinador/ayudaCord.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: "/agregarStd",
    name: "agregarStd",
    component: () => import('../views/coordinador/addEstudiante.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: "/datosCord",
    name: "datosCord",
    component: () => import('../views/coordinador/datosCoord.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: "/agregarOrgSoc",
    name: "agregarOrgSoc",
    component: () => import('../views/coordinador/addOrgSoc.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: "/subirPre",
    name: "subirPre",
    component: () => import('../views/coordinador/UploadFiles.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: '/estudiantes',
    name: 'estudiantesCord',
    component: () => import('../views/coordinador/EstudiantesCord.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: '/estudiantes2',
    name: 'estudiantesCord2',
    component: () => import('../views/coordinador/getEstudiantes.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: '/subirFile',
    name: 'subirFile',
    component: () => import('../views/coordinador/subirCsv.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: '/subirFileOrgSoc',
    name: 'subirFileOrgSoc',
    component: () => import('../views/coordinador/subirCsv.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: '/orgSociales',
    name: 'orgSociales',
    component: () => import('../views/coordinador/organizaciones.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: '/emprendimientos',
    name: 'emprendimientos',
    component: () => import('../views/coordinador/emprendimientos.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: '/addemprendimientos',
    name: 'addemprendimientos',
    component: () => import('../views/coordinador/addEmpren.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: '/docentes',
    name: 'docentes',
    component: () => import('../views/coordinador/docentes.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: '/addDocentes',
    name: 'addDocentes',
    component: () => import('../views/coordinador/addDocente.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: '/gruposClase',
    name: 'gruposClase',
    component: () => import('../views/coordinador/gruposClass.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: '/addGrupoClass',
    name: 'addGrupoClass',
    component: () => import('../views/coordinador/addGrupoClass.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: '/asignacion',
    name: 'asignacion',
    component: () => import('../views/coordinador/asignacionAct.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: '/asignacionNueva',
    name: 'asignacionNueva',
    component: () => import('../views/coordinador/asignacionNew.vue')
  },
  {
    path: '/CstuEdit',
    name: 'CstuEdit',
    component: () => import('../views/coordinador/estudianteEdit.vue')
  },
  {
    path: '/CpreEdit',
    name: 'CpreEdit',
    component: () => import('../views/coordinador/preEstudianteEdit.vue')
  },
  {
    path: '/CorgEdit',
    name: 'CorgEdit',
    component: () => import('../views/coordinador/organizacionEdit.vue')
  },
  {
    path: '/CdocEdit',
    name: 'CdocEdit',
    component: () => import('../views/coordinador/docenteEdit.vue')
  },
  {
    path: '/CclassEdit',
    name: 'CclassEdit',
    component: () => import('../views/coordinador/classEdit.vue')
  },
  {
    path: '/CempEdit',
    name: 'CempEdit',
    component: () => import('../views/coordinador/indicadoresEdit.vue')
    
  },
  {
    path: '/CindiEdit',
    name: 'CindiEdit',
    component: () => import('../views/coordinador/indicadoresEdit.vue')
    
  },
  {
    path: '/CindiCoord',
    name: 'CindiCoord',
    component: () => import('../views/coordinador/indicadoresCoord.vue')
    
  },
  //ADMIN
  {
    path: '/adminHome',
    name: 'adminHome',
    component: () => import('../views/admin/HomeAdmin.vue')
    ,meta: {requiresAuth: true}
    //,meta:{requiresRoleAdm: true}
  },
  {
    path: '/gesNoticias',
    name: 'gesNoticias',
    component: () => import('../views/admin/GNoticias.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: '/gesIndicadores',
    name: 'gesIndicadores',
    component: () => import('../views/admin/GIndicadores.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: '/gesCoordinador',
    name: 'gesCoordinador',
    component: () => import('../views/admin/GCoordinador.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: '/addCoord',
    name: 'addCoord',
    component: () => import('../views/admin/addCoordinador.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: '/gesForo',
    name: 'gesForo',
    component: () => import('../views/admin/GForo.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: '/foroEdit',
    name: 'foroEdit',
    component: () => import('../views/admin/foroEdit.vue')
  },
  {
    path: '/notiEdit',
    name: 'notiEdit',
    component: () => import('../views/admin/noticiasEdit.vue')
  },
  {
    path: '/stuEdit',
    name: 'stuEdit',
    component: () => import('../views/admin/estudianteEdit.vue')
  },
  {
    path: '/preEdit',
    name: 'preEdit',
    component: () => import('../views/admin/preEstudianteEdit.vue')
  },
  {
    path: '/gesStu',
    name: 'gesStu',
    component: () => import('../views/admin/estudianteAdmin.vue')
  },
  {
    path: '/orgAdmin',
    name: 'orgAdmin',
    component: () => import('../views/admin/organizacionAdmin.vue')
  },
  {
    path: '/orgEdit:id',
    name: 'orgEdit',
    component: () => import('../views/admin/organizacionEdit.vue')
  },
  {
    path: '/docEdit',
    name: 'docEdit',
    component: () => import('../views/admin/docenteEdit.vue')
  },
  {
    path: '/docAdmin',
    name: 'docAdmin',
    component: () => import('../views/admin/docenteAdmin.vue')
  },
  {
    path: '/classAdmin',
    name: 'classAdmin',
    component: () => import('../views/admin/classAdmin.vue')
  },
  {
    path: '/classEdit',
    name: 'classEdit',
    component: () => import('../views/admin/classEdit.vue')
  },
  {
    path: '/empAdmin',
    name: 'empAdmin',
    component: () => import('../views/admin/emprendimientoAdmin.vue')
  },
  {
    path: '/empEdit',
    name: 'empEdit',
    component: () => import('../views/admin/emprendimientoEdit.vue')
  },
  {
    path: '/coordEdit',
    name: 'coordEdit',
    component: () => import('../views/admin/coordinadorEdit.vue')
  },
  {
    path: '/indiEdit',
    name: 'indidEdit',
    component: () => import('../views/admin/indicadoresEdit.vue')
  },


  //EMPRENDIMIENTO
  {
    path: '/HomeEmp',
    name: 'HomeEmp',
    component: () => import('../views/emprendimiento/HomeEmp.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: '/datosEmp',
    name: 'datosEmp',
    component: () => import('../views/emprendimiento/ActualizarDatosEmp.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: '/dgvf',
    name: 'diagn',
    component: () => import('../views/emprendimiento/forDGV.vue')
    //,meta: {requiresAuth: true}
  },
  {
    path: '/bench',
    name: 'benchM',
    component: () => import('../views/emprendimiento/benchm.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: '/benchOS',
    name: 'benchOS',
    component: () => import('../views/orgSocial/benchmOS.vue')
    ,meta: {requiresAuth: true}
  },

   //DOCENTE
   {
    path: '/HomeDoc',
    name: 'HomeDoc',
    component: () => import('../views/docente/HomeDoc.vue')
    ,meta: {requiresAuth: true}
  },
  {
    path: '/datosDoc',
    name: 'datosDoc',
    component: () => import('../views/docente/ActualizarDatosDoc.vue')
    ,meta: {requiresAuth: true}
  },
    //EMPRENDIMIENTO
    {
      path: '/asesoria',
      name: 'asesoria',
      component: () => import('../views/emprendimiento/asesoria.vue')
      ,meta: {requiresAuth: true}
    },
    {
      path: '/foroEmp',
      name: 'foroEmp',
      component: () => import('../views/emprendimiento/foroEmp.vue')
      ,meta: {requiresAuth: true}
    },

    //ACTDATOSPre
    {
      path: '/datosPre',
      name: 'datosPre',
      component: () => import('../views/estudiante/ActualizarDatosPre.vue')
      ,meta: {requiresAuth: true}
    },
    //ACTDATOSEst
    {
      path: '/datosEs',
      name: 'datosEs',
      component: () => import('../views/estudiante/ActualizarDatosEst.vue')
      ,meta: {requiresAuth: true}
    },
    //requistosEst
    {
      path: '/reqEs',
      name: 'reqEs',
      component: () => import('../views/estudiante/Requisitos.vue')
    //  ,meta: {requiresAuth: true}
    },
    //SubirNoticia
    {
      path: '/noticiaEs',
      name: 'noticiaEs',
      component: () => import('../views/estudiante/SubirNoticia.vue')
      //,meta: {requiresAuth: true}
    },
    /*{
      path: '/benchmarking',
      name: 'Benchmarking',
      component: () => import("@/views/PreguntaBenchmarking.vue")
    }*/
]

const router = new VueRouter({
  routes
})

router.beforeEach((to,from,next) => {

if(to.meta.requiresAuth){
  if(!store.state.auth.user){
    next({
      path:"/login2"
    })
  }else{
    next();
  }
}else{
  next();
}
})
//////////////////////////////////////////ROle based///////////////////////////////////
router.beforeEach((to,from,next) => {

  if(to.meta.requiresRoleAdm){
    if(store.state.auth.user.role != "ROLE_ADMIN"){
      next({
        path:"/login2"
      })
    }else{
      next();
    }
  }else{
    next();
  }
  })
  router.beforeEach((to,from,next) => {

    if(to.meta.requiresRoleAdm){
      if(store.state.auth.user.role != "ROLE_STUDIANTE"){
        next({
          path:"/login2"
        })
      }else{
        next();
      }
    }else{
      next();
    }
    })
    router.beforeEach((to,from,next) => {

      if(to.meta.requiresRoleAdm){
        if(store.state.auth.user.role != "ROLE_ORGANIZACION"){
          next({
            path:"/login2"
          })
        }else{
          next();
        }
      }else{
        next();
      }
      })
      router.beforeEach((to,from,next) => {

        if(to.meta.requiresRoleAdm){
          if(store.state.auth.user.role != "ROLE_EMP"){
            next({
              path:"/login2"
            })
          }else{
            next();
          }
        }else{
          next();
        }
        })
        router.beforeEach((to,from,next) => {

          if(to.meta.requiresRoleAdm){
            if(store.state.auth.user.role != "ROLE_COORDINADOR"){
              next({
                path:"/login2"
              })
            }else{
              next();
            }
          }else{
            next();
          }
          })
          router.beforeEach((to,from,next) => {

            if(to.meta.requiresRoleAdm){
              if(store.state.auth.user.role != "ROLE_DOCENTE"){
                next({
                  path:"/login2"
                })
              }else{
                next();
              }
            }else{
              next();
            }
            })
            router.beforeEach((to,from,next) => {

              if(to.meta.requiresRoleAdm){
                if(store.state.auth.user.role != "ROLE_PREINSCRITO"){
                  next({
                    path:"/login2"
                  })
                }else{
                  next();
                }
              }else{
                next();
              }
              })


////////////////////////////////////////////////////////////////////////////////////////
export default router
