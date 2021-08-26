module.exports = {
    purge: {
        enabled: true,
        content: [
            './kotlin/*.js',
        ]
    },
    darkMode: false, // or 'media' or 'class'
    theme: {
        gradientColorStops: () => ({
            'primary': '#7f52ff',
            'secondary': '#ef4856'
        }),
        extend: {},
    },
    variants: {
        extend: {},
    },
    plugins: [],
}
