if (!("ace" in window)) {
    window["ace"] = {}
}
ace.config = {cookie_expiry: 604800, cookie_path: "", storage_method: 2};
if (!("vars" in window["ace"])) {
    window["ace"].vars = {}
}
ace.vars["very_old_ie"] = !("querySelector" in document.documentElement);
ace.settings = {
    is: function (B, A) {
        return (ace.data.get("settings", B + "-" + A) == 1)
    }, exists: function (B, A) {
        return (ace.data.get("settings", B + "-" + A) !== null)
    }, set: function (B, A) {
        ace.data.set("settings", B + "-" + A, 1)
    }, unset: function (B, A) {
        ace.data.set("settings", B + "-" + A, -1)
    }, remove: function (B, A) {
        ace.data.remove("settings", B + "-" + A)
    }, navbar_fixed: function (C, A, E, B) {
        if (ace.vars["very_old_ie"]) {
            return false
        }
        var C = C || "#navbar";
        if (typeof C === "string") {
            C = document.querySelector(C)
        }
        if (!C) {
            return false
        }
        A = A || false;
        E = E && true;
        if (!A && B !== false) {
            var F = null;
            if (ace.settings.is("sidebar", "fixed") || ((F = document.getElementById("sidebar")) && ace.hasClass(F, "sidebar-fixed"))) {
                ace.settings.sidebar_fixed(F, false, E)
            }
        }
        if (A) {
            if (!ace.hasClass(C, "navbar-fixed-top")) {
                ace.addClass(C, "navbar-fixed-top")
            }
            if (E !== false) {
                ace.settings.set("navbar", "fixed")
            }
        } else {
            ace.removeClass(C, "navbar-fixed-top");
            if (E !== false) {
                ace.settings.unset("navbar", "fixed")
            }
        }
        try {
            document.getElementById("ace-settings-navbar").checked = A
        } catch (D) {
        }
        if (window.jQuery) {
            jQuery(document).trigger("settings.ace", ["navbar_fixed", A, C])
        }
    }, sidebar_fixed: function (D, A, F, B) {
        if (ace.vars["very_old_ie"]) {
            return false
        }
        var D = D || "#sidebar";
        if (typeof D === "string") {
            D = document.querySelector(D)
        }
        if (!D) {
            return false
        }
        A = A || false;
        F = F && true;
        if (!A && B !== false) {
            var C = null;
            if (ace.settings.is("breadcrumbs", "fixed") || ((C = document.getElementById("breadcrumbs")) && ace.hasClass(C, "breadcrumbs-fixed"))) {
                ace.settings.breadcrumbs_fixed(C, false, F)
            }
        }
        if (A && B !== false && !ace.settings.is("navbar", "fixed")) {
            ace.settings.navbar_fixed(null, true, F)
        }
        if (A) {
            if (!ace.hasClass(D, "sidebar-fixed")) {
                ace.addClass(D, "sidebar-fixed");
                var G = document.getElementById("menu-toggler");
                if (G) {
                    ace.addClass(G, "fixed")
                }
            }
            if (F !== false) {
                ace.settings.set("sidebar", "fixed")
            }
        } else {
            ace.removeClass(D, "sidebar-fixed");
            var G = document.getElementById("menu-toggler");
            if (G) {
                ace.removeClass(G, "fixed")
            }
            if (F !== false) {
                ace.settings.unset("sidebar", "fixed")
            }
        }
        try {
            document.getElementById("ace-settings-sidebar").checked = A
        } catch (E) {
        }
        if (window.jQuery) {
            jQuery(document).trigger("settings.ace", ["sidebar_fixed", A, D])
        }
    }, breadcrumbs_fixed: function (C, A, D, B) {
        if (ace.vars["very_old_ie"]) {
            return false
        }
        var C = C || "#breadcrumbs";
        if (typeof C === "string") {
            C = document.querySelector(C)
        }
        if (!C) {
            return false
        }
        A = A || false;
        D = D && true;
        if (A && B !== false && !ace.settings.is("sidebar", "fixed")) {
            ace.settings.sidebar_fixed(null, true, D)
        }
        if (A) {
            if (!ace.hasClass(C, "breadcrumbs-fixed")) {
                ace.addClass(C, "breadcrumbs-fixed")
            }
            if (D !== false) {
                ace.settings.set("breadcrumbs", "fixed")
            }
        } else {
            ace.removeClass(C, "breadcrumbs-fixed");
            if (D !== false) {
                ace.settings.unset("breadcrumbs", "fixed")
            }
        }
        try {
            document.getElementById("ace-settings-breadcrumbs").checked = A
        } catch (E) {
        }
        if (window.jQuery) {
            jQuery(document).trigger("settings.ace", ["breadcrumbs_fixed", A, C])
        }
    }, main_container_fixed: function (D, A, C) {
        if (ace.vars["very_old_ie"]) {
            return false
        }
        A = A || false;
        C = C && true;
        var D = D || "#main-container";
        if (typeof D === "string") {
            D = document.querySelector(D)
        }
        if (!D) {
            return false
        }
        var B = document.getElementById("navbar-container");
        if (A) {
            if (!ace.hasClass(D, "container")) {
                ace.addClass(D, "container")
            }
            if (B && !ace.hasClass(B, "container")) {
                ace.addClass(B, "container")
            }
            if (C !== false) {
                ace.settings.set("main-container", "fixed")
            }
        } else {
            ace.removeClass(D, "container");
            if (B) {
                ace.removeClass(B, "container")
            }
            if (C !== false) {
                ace.settings.unset("main-container", "fixed")
            }
        }
        try {
            document.getElementById("ace-settings-add-container").checked = A
        } catch (E) {
        }
        if (navigator.userAgent.match(/webkit/i)) {
            var F = document.getElementById("sidebar");
            ace.toggleClass(F, "menu-min");
            setTimeout(function () {
                ace.toggleClass(F, "menu-min")
            }, 0)
        }
        if (window.jQuery) {
            jQuery(document).trigger("settings.ace", ["main_container_fixed", A, D])
        }
    }, sidebar_collapsed: function (D, B, F) {
        if (ace.vars["very_old_ie"]) {
            return false
        }
        var D = D || "#sidebar";
        if (typeof D === "string") {
            D = document.querySelector(D)
        }
        if (!D) {
            return false
        }
        B = B || false;
        if (B) {
            ace.addClass(D, "menu-min");
            if (F !== false) {
                ace.settings.set("sidebar", "collapsed")
            }
        } else {
            ace.removeClass(D, "menu-min");
            if (F !== false) {
                ace.settings.unset("sidebar", "collapsed")
            }
        }
        if (window.jQuery) {
            jQuery(document).trigger("settings.ace", ["sidebar_collapsed", B, D])
        }
        if (!window.jQuery) {
            var G = document.querySelector('.sidebar-collapse[data-target="#' + (D.getAttribute("id") || "") + '"]');
            if (!G) {
                G = D.querySelector(".sidebar-collapse")
            }
            if (!G) {
                return
            }
            var C = G.querySelector("[data-icon1][data-icon2]"), A, E;
            if (!C) {
                return
            }
            A = C.getAttribute("data-icon1");
            E = C.getAttribute("data-icon2");
            if (B) {
                ace.removeClass(C, A);
                ace.addClass(C, E)
            } else {
                ace.removeClass(C, E);
                ace.addClass(C, A)
            }
        }
    }
};
ace.settings.check = function (C, D) {
    if (!ace.settings.exists(C, D)) {
        return
    }
    var B = ace.settings.is(C, D);
    var A = {
        "navbar-fixed": "navbar-fixed-top",
        "sidebar-fixed": "sidebar-fixed",
        "breadcrumbs-fixed": "breadcrumbs-fixed",
        "sidebar-collapsed": "menu-min",
        "main-container-fixed": "container"
    };
    var E = document.getElementById(C);
    if (B != ace.hasClass(E, A[C + "-" + D])) {
        ace.settings[C.replace("-", "_") + "_" + D](null, B)
    }
};
ace.data_storage = function (A, E) {
    var C = "ace_";
    var D = null;
    var B = 0;
    if ((A == 1 || A === E) && "localStorage" in window && window["localStorage"] !== null) {
        D = ace.storage;
        B = 1
    } else {
        if (D == null && (A == 2 || A === E) && "cookie" in document && document["cookie"] !== null) {
            D = ace.cookie;
            B = 2
        }
    }
    this.set = function (F, H, G, J, L) {
        if (!D) {
            return
        }
        if (G === L) {
            G = H;
            H = F;
            if (G == null) {
                D.remove(C + H)
            } else {
                if (B == 1) {
                    D.set(C + H, G)
                } else {
                    if (B == 2) {
                        D.set(C + H, G, ace.config.cookie_expiry, J || ace.config.cookie_path)
                    }
                }
            }
        } else {
            if (B == 1) {
                if (G == null) {
                    D.remove(C + F + "_" + H)
                } else {
                    D.set(C + F + "_" + H, G)
                }
            } else {
                if (B == 2) {
                    var I = D.get(C + F);
                    var K = I ? JSON.parse(I) : {};
                    if (G == null) {
                        delete K[H];
                        if (ace.sizeof(K) == 0) {
                            D.remove(C + F);
                            return
                        }
                    } else {
                        K[H] = G
                    }
                    D.set(C + F, JSON.stringify(K), ace.config.cookie_expiry, J || ace.config.cookie_path)
                }
            }
        }
    };
    this.get = function (F, G, J) {
        if (!D) {
            return null
        }
        if (G === J) {
            G = F;
            return D.get(C + G)
        } else {
            if (B == 1) {
                return D.get(C + F + "_" + G)
            } else {
                if (B == 2) {
                    var H = D.get(C + F);
                    var I = H ? JSON.parse(H) : {};
                    return G in I ? I[G] : null
                }
            }
        }
    };
    this.remove = function (F, G, H) {
        if (!D) {
            return
        }
        if (G === H) {
            G = F;
            this.set(G, null)
        } else {
            this.set(F, G, null)
        }
    }
};
ace.cookie = {
    get: function (A) {
        var B = document.cookie, D, E = A + "=", C;
        if (!B) {
            return
        }
        C = B.indexOf("; " + E);
        if (C == -1) {
            C = B.indexOf(E);
            if (C != 0) {
                return null
            }
        } else {
            C += 2
        }
        D = B.indexOf(";", C);
        if (D == -1) {
            D = B.length
        }
        return decodeURIComponent(B.substring(C + E.length, D))
    }, set: function (A, G, F, D, C, B) {
        var E = new Date();
        if (typeof(F) == "object" && F.toGMTString) {
            F = F.toGMTString()
        } else {
            if (parseInt(F, 10)) {
                E.setTime(E.getTime() + (parseInt(F, 10) * 1000));
                F = E.toGMTString()
            } else {
                F = ""
            }
        }
        document.cookie = A + "=" + encodeURIComponent(G) + ((F) ? "; expires=" + F : "") + ((D) ? "; path=" + D : "") + ((C) ? "; domain=" + C : "") + ((B) ? "; secure" : "")
    }, remove: function (A, B) {
        this.set(A, "", -1000, B)
    }
};
ace.storage = {
    get: function (A) {
        return window["localStorage"].getItem(A)
    }, set: function (B, A) {
        window["localStorage"].setItem(B, A)
    }, remove: function (A) {
        window["localStorage"].removeItem(A)
    }
};
ace.sizeof = function (C) {
    var A = 0;
    for (var B in C) {
        if (C.hasOwnProperty(B)) {
            A++
        }
    }
    return A
};
ace.hasClass = function (A, B) {
    return (" " + A.className + " ").indexOf(" " + B + " ") > -1
};
ace.addClass = function (A, B) {
    if (!ace.hasClass(A, B)) {
        var C = A.className;
        A.className = C + (C.length ? " " : "") + B
    }
};
ace.removeClass = function (A, B) {
    ace.replaceClass(A, B)
};
ace.replaceClass = function (C, D, A) {
    var B = new RegExp(("(^|\\s)" + D + "(\\s|$)"), "i");
    C.className = C.className.replace(B, function (E, G, F) {
        return A ? (G + A + F) : " "
    }).replace(/^\s+|\s+$/g, "")
};
ace.toggleClass = function (A, B) {
    if (ace.hasClass(A, B)) {
        ace.removeClass(A, B)
    } else {
        ace.addClass(A, B)
    }
};
ace.isHTTMlElement = function (A) {
    return window.HTMLElement ? A instanceof HTMLElement : ("nodeType" in A ? A.nodeType == 1 : false)
};
ace.data = new ace.data_storage(ace.config.storage_method);