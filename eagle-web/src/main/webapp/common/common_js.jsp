<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<script type="text/javascript">
    var ctx = '${pageContext.request.contextPath}';
</script>

<script src="${pageContext.request.contextPath}/common/js/jquery/jquery-1.8.2.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/common/js/custom/validate.js" type="text/javascript"></script>