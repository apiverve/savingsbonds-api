from setuptools import setup, find_packages

setup(
    name='apiverve_i-bondrates',
    version='1.2.2',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='I-Bond Rates provides current and historical interest rates for US Series I Savings Bonds. I-Bonds are inflation-protected savings bonds with a composite rate made up of a fixed rate plus an inflation rate that adjusts every 6 months.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/savingsbonds?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
