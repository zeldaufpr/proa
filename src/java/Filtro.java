

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class Filtro implements PhaseListener {

    public void afterPhase(PhaseEvent event) {

        FacesContext facesContext = event.getFacesContext();
        String currentPage = facesContext.getViewRoot().getViewId();

        boolean isLoginPage = (currentPage.lastIndexOf("login.xhtml") > -1);
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        Object usuarioLogado = session.getAttribute("usuario");

        if (!isLoginPage && usuarioLogado == null) {
            NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
            nh.handleNavigation(facesContext, null, "login");
        }
        //USUARIO JA LOGADO NO SISTEMA
        if (isLoginPage && usuarioLogado != null) {
           
            facesContext.getViewRoot().setViewId("/logDuplicado.xhtml");
        }
    }

    public void beforePhase(PhaseEvent event) {
    }

    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}
